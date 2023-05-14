package plugin;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import appli.PluginDescriptor;
import appli.PluginLoader;
import appli.StatusPlugin;
import java.util.List;

public class MonitorUI  {
	PluginLoader pl;
	JLabel l;
	JTable table;
	DefaultTableModel tableModel;
	private static  MonitorUI _INSTANCE;
	public static MonitorUI getInstance () {
		 if (_INSTANCE == null ) {
			 _INSTANCE = new MonitorUI();
		 }
		return _INSTANCE;
		 
	 }
	private MonitorUI() {
		// TODO Auto-generated method stub
				 this.pl = PluginLoader.getInstance();
				JFrame frame = new JFrame();
				frame.setTitle("Monitor");
				frame.setSize(500,400);

				String col[] = {"Nom","Description", "Categorie", "Statut"};

				tableModel = new DefaultTableModel(col, 0);
				for(PluginDescriptor ps: pl.pluginDescriptors) {
					String nom = ps.getName();
					String description = ps.getDescription();
					String categorie = ps.getCategorie();
					StatusPlugin status = ps.getStatus();
					Object[] data = {nom,description, categorie, status};
					tableModel.addRow(data);
				}
				table = new JTable(tableModel);
				frame.add(table);
				frame.setVisible(true);
				
	}

	public void updateMonitorUI(List<PluginDescriptor> pluginDescriptors) {
		tableModel.setRowCount(0);
		for(PluginDescriptor ps: pluginDescriptors) {
			String nom = ps.getName();
			String description = ps.getDescription();
			String categorie = ps.getCategorie();
			StatusPlugin status = ps.getStatus();
			Object[] data = {nom,description, categorie, status};
			tableModel.addRow(data);
		}
	}
}
