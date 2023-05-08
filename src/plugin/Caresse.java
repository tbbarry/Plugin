package plugin;

import model.Animal;
import interfaces.IAction;

public class Caresse implements IAction {
	
	public void doAction(Animal a) {
		// TODO Auto-generated method stub
		int caresser = 10;
		if (a.getEtat() == 100) {
			System.out.println("Votre animal ne peut pas être plus heureux !");
		} else {
			if (a.getEtat() < 100 && a.getEtat() + caresser >= 100) {
				System.out.println("Votre animal a atteint est le plus heureux !");
				a.setEtat(100);
			} else if (a.getEtat() + caresser < 100) {
				System.out.println("Votre animal a meilleure mine !");
				a.setEtat(a.getEtat() + caresser);
			}
		}
		
		a.setEnergie(400);
		
	}

	
}