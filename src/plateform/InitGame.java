package plateform;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import appli.PluginDescriptor;
import appli.PluginLoader;
import model.Animal;
import ui.PluginSelectorUI;


public class InitGame implements Observer {
	PluginLoader pl;
	PluginSelectorUI ps;
	Animal a;
	List<PluginDescriptor> pluginDescriptors;
	public InitGame() {
		 /* Load plugins */
		 this.a = new Animal(20, 5, 25, 30, 50);
		 this.a.addObserver(this);
		this.pluginDescriptors = new ArrayList();
		pl = PluginLoader.getInstance();
		this.pluginDescriptors = pl.pluginDescriptors;
		/* Launch User Interface */
		this.showPluginSelectorUI(a, pluginDescriptors);
		
	}
	@SuppressWarnings("deprecation")
	void showPluginSelectorUI(Animal a, List<PluginDescriptor> pluginDescriptors ) {
		this.ps = new PluginSelectorUI(a, pluginDescriptors);
		System.out.println("fin" + a);
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//this.ps = new PluginSelectorUI(a, pluginDescriptors);
		System.out.println("fin" + a);
	}
	
}
