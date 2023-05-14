package plugin;

import interfaces.IAction;
import model.Animal;

public class Dormir implements IAction {
	@Override
	public void doAction(Animal a) {
		int dormir = 20;
		int etat = 10;
		if (a.getEtat() - etat < 0) {
			a.setEtat(0);
		} else {
			a.setEtat(a.getEtat() - etat);
			if (a.getEnergie() + dormir > 100) {
				a.setEnergie(100);
			} else {
				a.setEnergie(a.getEnergie() + dormir);
			}
		}

	}

}
