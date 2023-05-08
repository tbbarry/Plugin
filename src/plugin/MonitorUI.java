package plugin;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import appli.PluginDescriptor;
import appli.PluginLoader;
import appli.StatusPlugin;
import interfaces.IMonitor;

import java.util.Observable;
import java.util.Observer;

public class MonitorUI implements Observer {
	PluginLoader pl;
	public MonitorUI() {
		// TODO Auto-generated method stub
				 this.pl = PluginLoader.getInstance();
				JFrame frame = new JFrame();
				frame.setTitle("Monitor");
				frame.setSize(200,200);

				String col[] = {"Nom","Description", "Categorie", "Statut"};

				DefaultTableModel tableModel = new DefaultTableModel(col, 0);
				for(PluginDescriptor ps: pl.pluginDescriptors) {
					String nom = ps.getName();
					String description = ps.getDescription();
					String categorie = ps.getCategorie();
					StatusPlugin status = ps.getStatus();
					Object[] data = {nom,description, categorie, status};
					tableModel.addRow(data);
				}
				JTable table = new JTable(tableModel);
				frame.add(table);
				frame.setVisible(true);
	}

	@Override
	public void update(Observable observable, Object o) {
		System.out.println("Modification ");
	}
}
