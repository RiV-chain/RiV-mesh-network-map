package demo.more;

import org.zkoss.chart.model.DefaultFromToModel;
import org.zkoss.chart.model.FromToModel;

public class NetworkGraphData {
    private static final FromToModel model;

    static {
        model = new DefaultFromToModel();
        model.addValue("lang-tree", "Proto Indo-European", "Balto-Slavic");
        model.addValue("lang-tree", "Proto Indo-European", "Germanic");
        model.addValue("lang-tree", "Proto Indo-European", "Celtic");
        model.addValue("lang-tree", "Proto Indo-European", "Italic");
        model.addValue("lang-tree", "Proto Indo-European", "Hellenic");
        model.addValue("lang-tree", "Proto Indo-European", "Anatolian");
        model.addValue("lang-tree", "Proto Indo-European", "Indo-Iranian");
        model.addValue("lang-tree", "Proto Indo-European", "Tocharian");
        model.addValue("lang-tree", "Indo-Iranian", "Dardic");
        model.addValue("lang-tree", "Indo-Iranian", "Indic");
        model.addValue("lang-tree", "Indo-Iranian", "Iranian");
        model.addValue("lang-tree", "Iranian", "Old Persian");
        model.addValue("lang-tree", "Old Persian", "Middle Persian");
        model.addValue("lang-tree", "Indic", "Sanskrit");
        model.addValue("lang-tree", "Italic", "Osco-Umbrian");
        model.addValue("lang-tree", "Italic", "Latino-Faliscan");
        model.addValue("lang-tree", "Latino-Faliscan", "Latin");
        model.addValue("lang-tree", "Celtic", "Brythonic");
        model.addValue("lang-tree", "Celtic", "Goidelic");
        model.addValue("lang-tree", "Germanic", "North Germanic");
        model.addValue("lang-tree", "Germanic", "West Germanic");
        model.addValue("lang-tree", "Germanic", "East Germanic");
        model.addValue("lang-tree", "North Germanic", "Old Norse");
        model.addValue("lang-tree", "North Germanic", "Old Swedish");
        model.addValue("lang-tree", "North Germanic", "Old Danish");
        model.addValue("lang-tree", "West Germanic", "Old English");
        model.addValue("lang-tree", "West Germanic", "Old Frisian");
        model.addValue("lang-tree", "West Germanic", "Old Dutch");
        model.addValue("lang-tree", "West Germanic", "Old Low German");
        model.addValue("lang-tree", "West Germanic", "Old High German");
        model.addValue("lang-tree", "Old Norse", "Old Icelandic");
        model.addValue("lang-tree", "Old Norse", "Old Norwegian");
        model.addValue("lang-tree", "Old Norwegian", "Middle Norwegian");
        model.addValue("lang-tree", "Old Swedish", "Middle Swedish");
        model.addValue("lang-tree", "Old Danish", "Middle Danish");
        model.addValue("lang-tree", "Old English", "Middle English");
        model.addValue("lang-tree", "Old Dutch", "Middle Dutch");
        model.addValue("lang-tree", "Old Low German", "Middle Low German");
        model.addValue("lang-tree", "Old High German", "Middle High German");
        model.addValue("lang-tree", "Balto-Slavic", "Baltic");
        model.addValue("lang-tree", "Balto-Slavic", "Slavic");
        model.addValue("lang-tree", "Slavic", "East Slavic");
        model.addValue("lang-tree", "Slavic", "West Slavic");
        model.addValue("lang-tree", "Slavic", "South Slavic");
        // Leaves:
        model.addValue("lang-tree", "Proto Indo-European", "Phrygian");
        model.addValue("lang-tree", "Proto Indo-European", "Armenian");
        model.addValue("lang-tree", "Proto Indo-European", "Albanian");
        model.addValue("lang-tree", "Proto Indo-European", "Thracian");
        model.addValue("lang-tree", "Tocharian", "Tocharian A");
        model.addValue("lang-tree", "Tocharian", "Tocharian B");
        model.addValue("lang-tree", "Anatolian", "Hittite");
        model.addValue("lang-tree", "Anatolian", "Palaic");
        model.addValue("lang-tree", "Anatolian", "Luwic");
        model.addValue("lang-tree", "Anatolian", "Lydian");
        model.addValue("lang-tree", "Iranian", "Balochi");
        model.addValue("lang-tree", "Iranian", "Kurdish");
        model.addValue("lang-tree", "Iranian", "Pashto");
        model.addValue("lang-tree", "Iranian", "Sogdian");
        model.addValue("lang-tree", "Old Persian", "Pahlavi");
        model.addValue("lang-tree", "Middle Persian", "Persian");
        model.addValue("lang-tree", "Hellenic", "Greek");
        model.addValue("lang-tree", "Dardic", "Dard");
        model.addValue("lang-tree", "Sanskrit", "Sindhi");
        model.addValue("lang-tree", "Sanskrit", "Romani");
        model.addValue("lang-tree", "Sanskrit", "Urdu");
        model.addValue("lang-tree", "Sanskrit", "Hindi");
        model.addValue("lang-tree", "Sanskrit", "Bihari");
        model.addValue("lang-tree", "Sanskrit", "Assamese");
        model.addValue("lang-tree", "Sanskrit", "Bengali");
        model.addValue("lang-tree", "Sanskrit", "Marathi");
        model.addValue("lang-tree", "Sanskrit", "Gujarati");
        model.addValue("lang-tree", "Sanskrit", "Punjabi");
        model.addValue("lang-tree", "Sanskrit", "Sinhalese");
        model.addValue("lang-tree", "Osco-Umbrian", "Umbrian");
        model.addValue("lang-tree", "Osco-Umbrian", "Oscan");
        model.addValue("lang-tree", "Latino-Faliscan", "Faliscan");
        model.addValue("lang-tree", "Latin", "Portugese");
        model.addValue("lang-tree", "Latin", "Spanish");
        model.addValue("lang-tree", "Latin", "French");
        model.addValue("lang-tree", "Latin", "Romanian");
        model.addValue("lang-tree", "Latin", "Italian");
        model.addValue("lang-tree", "Latin", "Catalan");
        model.addValue("lang-tree", "Latin", "Franco-Provençal");
        model.addValue("lang-tree", "Latin", "Rhaeto-Romance");
        model.addValue("lang-tree", "Brythonic", "Welsh");
        model.addValue("lang-tree", "Brythonic", "Breton");
        model.addValue("lang-tree", "Brythonic", "Cornish");
        model.addValue("lang-tree", "Brythonic", "Cuymbric");
        model.addValue("lang-tree", "Goidelic", "Modern Irish");
        model.addValue("lang-tree", "Goidelic", "Scottish Gaelic");
        model.addValue("lang-tree", "Goidelic", "Manx");
        model.addValue("lang-tree", "East Germanic", "Gothic");
        model.addValue("lang-tree", "Middle Low German", "Low German");
        model.addValue("lang-tree", "Middle High German", "(High) German");
        model.addValue("lang-tree", "Middle High German", "Yiddish");
        model.addValue("lang-tree", "Middle English", "English");
        model.addValue("lang-tree", "Middle Dutch", "Hollandic");
        model.addValue("lang-tree", "Middle Dutch", "Flemish");
        model.addValue("lang-tree", "Middle Dutch", "Dutch");
        model.addValue("lang-tree", "Middle Dutch", "Limburgish");
        model.addValue("lang-tree", "Middle Dutch", "Brabantian");
        model.addValue("lang-tree", "Middle Dutch", "Rhinelandic");
        model.addValue("lang-tree", "Old Frisian", "Frisian");
        model.addValue("lang-tree", "Middle Danish", "Danish");
        model.addValue("lang-tree", "Middle Swedish", "Swedish");
        model.addValue("lang-tree", "Middle Norwegian", "Norwegian");
        model.addValue("lang-tree", "Old Norse", "Faroese");
        model.addValue("lang-tree", "Old Icelandic", "Icelandic");
        model.addValue("lang-tree", "Baltic", "Old Prussian");
        model.addValue("lang-tree", "Baltic", "Lithuanian");
        model.addValue("lang-tree", "Baltic", "Latvian");
        model.addValue("lang-tree", "West Slavic", "Polish");
        model.addValue("lang-tree", "West Slavic", "Slovak");
        model.addValue("lang-tree", "West Slavic", "Czech");
        model.addValue("lang-tree", "West Slavic", "Wendish");
        model.addValue("lang-tree", "East Slavic", "Bulgarian");
        model.addValue("lang-tree", "East Slavic", "Old Church Slavonic");
        model.addValue("lang-tree", "East Slavic", "Macedonian");
        model.addValue("lang-tree", "East Slavic", "Serbo-Croatian");
        model.addValue("lang-tree", "East Slavic", "Slovene");
        model.addValue("lang-tree", "South Slavic", "Russian");
        model.addValue("lang-tree", "South Slavic", "Ukrainian");
        model.addValue("lang-tree", "South Slavic", "Belarusian");
        model.addValue("lang-tree", "South Slavic", "Rusyn");
    }

    public static FromToModel getModel() {
        return model;
    }
}