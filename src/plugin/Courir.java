package plugin;

import interfaces.IAction;
import model.Animal;

public class Courir implements IAction{

	@Override
	public void doAction(Animal a) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				int courir = 20;
				int diminution = 10;
				if (a.getEnergie() - diminution < 1 || a.getFaim() - diminution < 1) {
					System.out.println("Votre animal a trop faim ou n'a pas assez d'énergie pour courir ! \n");
				} else {
					if (a.getSante() < 100 && a.getSante() + courir >= 100) {
						a.setSante(100);
						a.setEnergie(a.getEnergie() - diminution);
						a.setFaim(a.getFaim() - diminution);
						System.out.println("Votre animal a bien couru ! \n");
					}
				}
		
	}

}
