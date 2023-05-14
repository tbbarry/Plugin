package plugin;

import interfaces.IAction;
import model.Animal;

public class Manger implements IAction{

	@Override
	public void doAction(Animal a) {
		int manger = 20;
		int hp = 10;
		if (a.getSante() - hp < 0) {
			a.setSante(0);
		} else {
			a.setSante(a.getSante() - hp);
			if (a.getFaim() + manger > 100) {
				a.setFaim(100);
			} else {
				a.setFaim(a.getFaim() + manger);
			} 
		}
	}


}
