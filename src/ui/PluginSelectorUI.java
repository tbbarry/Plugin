package ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import appli.PluginLoader;
import appli.StatusPlugin;
import appli.PluginDescriptor;
import interfaces.IAction;
import interfaces.IMonitor;
import model.Animal;
import plugin.MonitorUI;

/**
 * Interface graphique pour selectionner les plugins à charger.
 */
@SuppressWarnings("serial")
public class PluginSelectorUI extends JFrame implements Observer{
	PluginLoader pl;
	MonitorUI monitor;
	JFrame frame;
	JLabel gif;
	ImageIcon ii;
	@SuppressWarnings("deprecation")
	public PluginSelectorUI(Animal a, List<PluginDescriptor> pluginDescriptors) {
	      super();
	      frame = new JFrame();
	      gif = new JLabel();
	      this.pl = PluginLoader.getInstance();
	      this.monitor = MonitorUI.getInstance();
	      JPanel northP = new JPanel();
	      JPanel southP = new JPanel();
	      JPanel centerP = new JPanel();
	      JTextArea pc = new JTextArea(5, 20);
	      JLabel gif = new JLabel();
	      JLabel t1 = new JLabel("Animal ");
	      JLabel t2 = new JLabel("Attributs:  Santé: " + a.getSante() + " Energie: " + a.getEnergie() + " Faim: " + a.getFaim() + " Etat: " + a.getEtat());
	      northP.add(t1);
	      northP.add(t2);
	      System.out.println(pluginDescriptors);
	      for(PluginDescriptor pd: pl.getDescriptorForCategorie("action")) {
	    		  JButton btn = new JButton(pd.getName());
		    	  southP.add(btn);
		    	   btn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							IAction action = (IAction) pl.instantiatePluginClass(pd);
							action.doAction(a);
							t2.setText("Attributs:  Santé: " + a.getSante() + " Energie: " + a.getEnergie() + " Faim: " + a.getFaim() +" Etat: " + a.getEtat());
							System.out.println(a.toString());
							pc.setText("Name: " + pd.getName() +"\nClassName: " + pd.getClassName() + " \nDescription: " + pd.getDescription() + "\nCategorie: " + pd.getCategorie() + "\nAuto run: " + pd.getAutoRun());
							repaint();
							// Chargement giF
							if(a.getSante()>75) {
								ii = new ImageIcon(this.getClass().getResource("/img/Happy.gif"));
							 }else if(a.getSante()>50) {
								ii = new ImageIcon(this.getClass().getResource("/img/Happy_mid.gif"));
							 }else if(a.getSante()>25) {
								ii = new ImageIcon(this.getClass().getResource("/img/Mid_Bad.gif"));
							}else if(a.getSante()>=0) {
								 ii = new ImageIcon(this.getClass().getResource("/img/Bad.gif"));
							}
							gif.setIcon(ii);

							 monitor.updateMonitorUI(pl.pluginDescriptors);
						}
			    	});
	      }
	      northP.setOpaque(true);
	      southP.setOpaque(true);
	      ImageIcon ii = new ImageIcon(this.getClass().getResource("/img/Happy.gif"));
      	  gif.setIcon(ii);
      	  centerP.add(gif, java.awt.BorderLayout.CENTER);
	      frame.setTitle("Titre de la Fenetre ");
	      frame.setJMenuBar(createMenuBar());
	      frame.setSize(700, 700);
	      frame.setLayout(new BorderLayout());
	      frame. add(northP, BorderLayout.NORTH);
	      frame.add(southP, BorderLayout.SOUTH);
	      pc.setText("Ici les pluggins chargés seront affichés");
	      pc.setEditable(false);
	      frame.add(centerP, BorderLayout.CENTER);
         // DarkBackground bg = new DarkBackground();
         // bg.background(frame);
	      	

	      frame.setVisible(true);
	      pc.setOpaque(true);
	    	
	    	
	   }
	  public JMenuBar createMenuBar() {
		   JMenuBar menuBar = new JMenuBar();
		   menuBar.setOpaque(false);
	       JMenu menuFile = new JMenu( "Affichage" );
	       JMenuItem i1 = new JMenuItem( "Simple" );
	       menuFile.add(i1);
	       JMenuItem i2 = new JMenuItem( "Style" );
	       menuFile.add(i2);
	       menuBar.add(menuFile);
	       
	       JMenu menuAction = new JMenu( "Action" );
	       JMenuItem i3 = new JMenuItem( "Manger" );
	       menuAction.add(i3);
	       JMenuItem i4 = new JMenuItem( "Dormir" );
	       
	       menuAction.add(i4);
	       menuBar.add(menuAction);
	     
		return menuBar;
		   
	   }
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		frame.invalidate();
		frame.validate();
		frame.repaint();
		
		System.out.println("update");
	}
}
