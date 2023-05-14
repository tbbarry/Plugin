package plugin;

import interfaces.IAction;
import model.Animal;

public class Courir implements IAction{

	@Override
	public void doAction(Animal a) {
		int courir = 20;
		int faim = 10;
		if (a.getFaim() - faim < 0) {
			a.setFaim(0);
		} else {
			a.setFaim(a.getFaim() - faim);
			if (a.getSante() + courir > 100) {
				a.setSante(100);
			} else {
				a.setSante(a.getSante() + courir);
			}
		}
	}

}
