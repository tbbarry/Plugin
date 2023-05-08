package appli;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import interfaces.IMonitor;
import plugin.MonitorUI;




public class PluginLoader {
	private final static String CONFIG_FILENAME = "src/plugin.json";
	private static  PluginLoader _INSTANCE;
	public  List<PluginDescriptor> pluginDescriptors;
	 public static PluginLoader getInstance () {
		 if (_INSTANCE == null ) {
			 _INSTANCE = new PluginLoader();
		 }
		return _INSTANCE;
		 
	 }
	 PluginLoader () {
		 this.pluginDescriptors = new ArrayList();
	 }
     public static void main(String[] args) {
    	 PluginLoader pl = PluginLoader.getInstance();
    	 pl.loadPulginsDescriptors();
    	 //init autorun plugin
    	 for(PluginDescriptor pd: pl.getDescriptorForCategorie("application")) {
    		System.out.println(pd.getName()); 
 	    	if(pd.autoRun) {
 	    		pd.setStatus(StatusPlugin.Charge);
 	    		pl.instantiatePluginClass(pd);
 	    		pd.setStatus(StatusPlugin.Charge);
 	    	}
 	      }
    	 System.out.println(pl.getDescriptorForCategorie("application"));
     }

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
     public List<PluginDescriptor> getDescriptorForCategorie(String categorie) {
    	 List<PluginDescriptor> descriptors=  new ArrayList();
    	 for(PluginDescriptor pd : pluginDescriptors) {
    		 if(pd.getCategorie().equals(categorie)) {
    			 descriptors.add(pd);
    		 }
    	 }
    	 return descriptors;
     }
     public  Object  instantiatePluginClass(PluginDescriptor pd) {
		Object plugin = null;
		 try {
			plugin = Class.forName(pd.getClassName()).newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plugin;
		
	}
   
    
}