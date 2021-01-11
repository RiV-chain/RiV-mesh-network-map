package demo.more;

import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import demo.comparator.NodeDataPairSortByCoords;
import demo.node.NodeDataPair;

public class NetworkDHTCrawler {
	
	private static final Logger log = LoggerFactory.getLogger(NetworkDHTCrawler.class);
	
	private static final String ADMIN_API_HOST="localhost";
	
	private static final int ADMIN_API_PORT=9001;
	
	private static ExecutorService threadPool = Executors.newFixedThreadPool(10);
	
	private static Queue<Future<Map<String, NodeData>>> queue = null;
	
	public static Set<NodeDataPair> nodes = new TreeSet<NodeDataPair>(new NodeDataPairSortByCoords());
	
	private void run(String json, Class<?> class_) {

		queue.add(threadPool.submit(new Callable<Map<String, NodeData>>() {
			
			@Override
			public Map<String, NodeData> call() throws Exception {
				log.info("found: "+nodes.size()+" records");
				final ApiNodesResponse nodesReponse = (ApiNodesResponse)apiRequest(json, class_);
				if(nodesReponse==null) {
					return new HashMap<String, NodeData>();
				}
				if(nodesReponse.getResponse()==null) {
					Gson gson = new Gson();
					log.info("incorrect response: "+gson.toJson(nodesReponse));
					return new HashMap<String, NodeData>();
				}
				if(nodesReponse.getResponse().getNodes()==null) {
					Gson gson = new Gson();
					log.info("incorrect response: "+gson.toJson(nodesReponse));
					return new HashMap<String, NodeData>();
				}
				final Map<String, NodeData> nodes = nodesReponse.getResponse().getNodes();
				for(final Entry<String, NodeData> nodeEntry:nodes.entrySet()) {
					//duplicated values are checked by Set
					if(NetworkDHTCrawler.nodes.contains(new NodeDataPair(nodeEntry.getKey(), nodeEntry.getValue()))) {
						continue;
					}
					NetworkDHTCrawler.nodes.add(new NodeDataPair(nodeEntry.getKey(), nodeEntry.getValue()));
					//nodes.put(nodeEntry.getKey(), nodeEntry.getValue());
					final String nodeJson = new ApiRequest().dhtPing(nodeEntry.getValue().getBox_pub_key(), nodeEntry.getValue().getCoords()).serialize();
					NetworkDHTCrawler.this.run(nodeJson, ApiNodesResponse.class);
				}
				return nodes;
			}    
		}));
	}
	
	
	private Object apiRequest(String json, Class<?> class_) {
		
		String response = null;
		byte[] cbuf = new byte[1024];
		Socket clientSocket = null;
		DataOutputStream os = null;
        InputStream is = null;
		StringBuilder sb = new StringBuilder();
		try {
			clientSocket = new Socket(ADMIN_API_HOST, ADMIN_API_PORT);
			os = new DataOutputStream(clientSocket.getOutputStream());
			os.writeBytes(json);
			System.out.println(json);
			System.out.println("Total nodes:"+NetworkDHTCrawler.nodes.size());
			int i = 0;
			is = clientSocket.getInputStream();
			while((i = is.read(cbuf))>0) {
				sb.append(new String(Arrays.copyOf(cbuf, i)));
			}
			response = sb.toString();
			System.out.println(response);
		} catch (java.net.SocketException e) {
			//System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			os.close();
			is.close();
            clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		Object apiReponse = null;
		try {
			//System.out.println(response);
			apiReponse = gson.fromJson(response, class_);
			//System.out.println(gson.toJson(apiReponse));
		} catch(JsonSyntaxException e) {
			e.printStackTrace();
			System.out.println(response);
		}
		if(apiReponse==null) {
			System.out.println("No response received");
			//System.exit(-1);
		}
		return apiReponse;
	}
	
	public static void main(String args[]) throws InterruptedException, ExecutionException, IOException {
		queue = new ConcurrentLinkedQueue<Future<Map<String, NodeData>>>();
		String json = new ApiRequest().getDHT().serialize();
		NetworkDHTCrawler crawler = new NetworkDHTCrawler();
		ApiDHTResponse dhtReponse = (ApiDHTResponse)crawler.apiRequest(json, ApiDHTResponse.class);
		if(dhtReponse==null) {
			System.exit(1);
		}
		//String json = new ApiRequest().dhtPing("5db525ea8fa6d3f20b5bb3d6d810f047ca447987e177532f78ed01713f459414", "[1 13]").serialize();
		Map<String, NodeData> localDHT = dhtReponse.getResponse().getDht();
		
		for(Entry<String, NodeData> dhtEntry:localDHT.entrySet()) {
			nodes.add(new NodeDataPair(dhtEntry.getKey(), dhtEntry.getValue()));
			if(dhtEntry.getValue().getCoords().equals("[1]")) {
				//skip self looping
				continue;
			}
			String nodeJson = new ApiRequest().dhtPing(dhtEntry.getValue().getBox_pub_key(), dhtEntry.getValue().getCoords()).serialize();
			crawler.run(nodeJson, ApiNodesResponse.class);
		}
		for(Future<Map<String, NodeData>> item:queue) {
			try {
				Map<String, NodeData> map = item.get();
				//for(Entry<String, NodeData> node:map.entrySet()) {
				//	nodes.add(new NodeDataPair(node.getKey(), node.getValue()));
				//}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		try (Writer writer = new FileWriter("nodes.json")) {
		    Gson gson = new GsonBuilder().setPrettyPrinting().create();
		    gson.toJson(nodes, writer);
		}
		System.out.println("done");
		threadPool.shutdownNow();
	}
}