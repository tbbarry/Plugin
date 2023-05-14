package appli;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

/**
 * Class singleton permettant de charger les plugins.
 * Instancier les plugins qui sont en auto run
 */

public class PluginLoader {
	private final static String CONFIG_FILENAME = "src/plugin.json";
	private static  PluginLoader _INSTANCE;
	public  List<PluginDescriptor> pluginDescriptors; // La liste des plugins
	
	 /**
     * Rendre singleton la class.
     * Si elle a été une fois instanciée on retourne l'instance
     * Au cas contraire on cree une instance
     */
	 public static PluginLoader getInstance () {
		 if (_INSTANCE == null ) {
			 _INSTANCE = new PluginLoader();
		 }
		return _INSTANCE;
		 
	 }
	 PluginLoader () {
		 this.pluginDescriptors = new ArrayList<PluginDescriptor>(); 
	 }
	 
	 /**
	     * Point d'entré.
	     * Instanciation pour la première le singleton
	     * Lancement des plugins qui sont à auto run en parcourant la liste des plugins
	     * @param name Le nouveau nom de l'animal.
	     */
     public static void main(String[] args) {
    	 PluginLoader pl = PluginLoader.getInstance(); 
    	 pl.loadPulginsDescriptors();
    	 for(PluginDescriptor pd: pl.getDescriptorForCategorie("application")) {
    		System.out.println(pd.getName()); 
 	    	if(pd.autoRun) {
 	    		pd.setStatus(StatusPlugin.Charge);
 	    		pl.instantiatePluginClass(pd);
 	    	}
 	      }
    	 System.out.println(pl.getDescriptorForCategorie("application"));
     }

     /**
      * Ouvrir le fichier json contenant la description de tous les plugins.
      * Creer une liste des pluginDescriptor à partir du contenu json du fichier
      */
     public  void loadPulginsDescriptors() {
    	 PluginDescriptor[] descriptors= {};
    	 try {
			descriptors  = new GsonBuilder().create().fromJson(
						new FileReader(CONFIG_FILENAME), PluginDescriptor[].class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	 for (PluginDescriptor pd : descriptors) {
    		 
    		 pluginDescriptors.add(new PluginDescriptor(
    				  pd.getName(), pd.getDescription(), pd.getClassName(), pd.getCategorie(), pd.getAutoRun()
    				 ));
    	 }
    	 for (PluginDescriptor pd : pluginDescriptors) {
    		System.out.print(pd.getClassName());
    	 }
    	 
     }
     /**
      * @param categorie plugin.
      * @return une liste des plugins correspondant à la categorie
      */
     public List<PluginDescriptor> getDescriptorForCategorie(String categorie) {
    	 List<PluginDescriptor> descriptors=  new ArrayList<PluginDescriptor>();
    	 for(PluginDescriptor pd : pluginDescriptors) {
    		 if(pd.getCategorie().equals(categorie)) {
    			 descriptors.add(pd);
    		 }
    	 }
    	 return descriptors;
     }
     /**
      * Instancier à la demande un plugin.
      * Met à jour l'etat du plugin s'il est charger ou pas
      * @param la description du plugin à instancier.
      * @return un objet dont le type est IAction
      */
     public  Object  instantiatePluginClass(PluginDescriptor pd) {
		Object plugin = null;
		 try {
			plugin = Class.forName(pd.getClassName()).newInstance();
			pd.setStatus(StatusPlugin.Charge);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			pd.setStatus(StatusPlugin.echec);
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pd.setStatus(StatusPlugin.echec);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pd.setStatus(StatusPlugin.echec);
		}
		return plugin;
		
	}
   
    
}