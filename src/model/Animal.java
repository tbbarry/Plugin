package model;
public class Animal {
	private int sante;
	private int faim;
	private int humeur;
	private int energie;
	public int etat;
	public Animal(int sante, int faim, int humeur, int energie, int etat) {
		this.sante = sante;
		this.faim = faim;
		this.humeur = humeur;
		this.energie = energie;
		this.etat = etat;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public int getSante() {
		return sante;
	}
	@Override
	public String toString() {
		return "Animal [sante=" + sante + ", faim=" + faim + ", humeur=" + humeur + ", energie=" + energie + "]";
	}
	public void setSante(int sante) {
		this.sante = sante;
		
	}
	public int getFaim() {
		return faim;
	}
	public void setFaim(int faim) {
		
		this.faim = faim;
	}
	public int getHumeur() {
		return humeur;
	}
	public void setHumeur(int humeur) {
		this.humeur = humeur;
	}
	public int getEnergie() {
		return energie;
	}
	public void setEnergie(int energie) {
		this.energie = energie;
	}
}
