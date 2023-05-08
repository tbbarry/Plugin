package plugin;

import interfaces.IAction;
import model.Animal;

public class Manger implements IAction{

	@Override
	public void doAction(Animal a) {
		int manger = 20;
		if (a.getFaim() + manger > 100) {
			a.setFaim(100);
		} else {
			a.setFaim(a.getFaim() + manger);
		}
		System.out.println("Votre animal a bien mangé ! \n");    
		
	}
	public void manger() {
		System.out.println("manger") ;                      
	}

}
