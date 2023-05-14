package plugin;

import model.Animal;
import interfaces.IAction;

public class Caresse implements IAction {
	
	public void doAction(Animal a) {
		// TODO Auto-generated method stub
		
		int caresser = 20;
		int faim = 10;
		if (a.getEnergie() - faim < 0) {
			a.setEnergie(0);
		} else {
			a.setEnergie(a.getEnergie() - faim);
			if (a.getEtat() + caresser > 100) {
				a.setEtat(100);
			} else {
				a.setEtat(a.getEtat() + caresser);
			}
		}
		
	}

	
}