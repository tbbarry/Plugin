package plugin;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;

import interfaces.IDisplayBackground;

public class DarkBackground implements IDisplayBackground {

	@Override
	public void background(JFrame frame) {
		// TODO Auto-generated method stub
		
		
		for(Component c: frame.getComponents()) {
			c.setBackground(Color.BLACK);
		}
	
		
	}
	
}
