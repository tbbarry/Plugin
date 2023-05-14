package plateform;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import appli.PluginDescriptor;
import appli.PluginLoader;
import model.Animal;
import plugin.MonitorUI;
import ui.PluginSelectorUI;

/**
 * Afficher l'interface graphique des plugins
 * Afficher le monitor
 * Creation de l' animal
 */
public class InitGame  {
	PluginLoader pl;
	PluginSelectorUI ps;
	MonitorUI monitor;
	Animal a;
	List<PluginDescriptor> pluginDescriptors;
	public InitGame() {
		 /* Load plugins */
		 this.a = new Animal(20, 5, 25, 30, 50);
		this.pluginDescriptors = new ArrayList<PluginDescriptor>();
		pl = PluginLoader.getInstance();
		this.pluginDescriptors = pl.pluginDescriptors;
		/* Launch User Interface */
		this.showPluginSelectorUI(a, pluginDescriptors);
		monitor = MonitorUI.getInstance();
	}
	@SuppressWarnings("deprecation")
	void showPluginSelectorUI(Animal a, List<PluginDescriptor> pluginDescriptors ) {
		this.ps = new PluginSelectorUI(a, pluginDescriptors);
		System.out.println("fin" + a);
		
	}
	
}
