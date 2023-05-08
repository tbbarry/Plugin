package plugin;

import interfaces.IAction;
import model.Animal;

public class Dormir implements IAction {
	@Override
	public void doAction(Animal a) {
		int dormir = 20;
		int diminution = 10;
		if (a.getHumeur() - diminution < 1 || a.getFaim() - diminution < 1) {
			System.out.println("Votre animal a trop faim ou n'est pas de bonne humeur pour dormir ! \n");
		} else {
			if (a.getEnergie() < 100 && a.getEnergie() + dormir >= 100) {
				a.setEnergie(100);
			} else {
				a.setEnergie(a.getEnergie() + dormir);
			}
			a.setHumeur(a.getHumeur() - diminution);
			a.setFaim(a.getFaim() - diminution);
			System.out.println("Votre animal a bien dormi ! \n");
		}

	}

}
