package entities;

public class Animal {
	public int hp;
	public int energie;
	public int etat;
	public int faim;

	
	public Animal() {
		super();
		this.hp = 100;
		this.energie = 100;
		this.etat = 100;
		this.faim = 100;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getEnergie() {
		return energie;
	}
	
	public void setEnergie(int energie) {
		this.energie = energie;
	}
	
	public int getEtat() {
		return etat;
	}
	
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public int getFaim() {
		return faim;
	}
	
	public void setFaim(int faim) {
		this.faim = faim;
	}
	
	
}
