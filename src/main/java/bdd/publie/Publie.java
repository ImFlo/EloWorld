package bdd.publie;

public class Publie {
	private int idJoueur;
	private int idJeu;
	private int idPublication;


	public Publie(int idJoueur, int idJeu, int idPublication) {
		this.idJoueur = idJoueur;
		this.idJeu = idJeu;
		this.idPublication = idPublication;
	}

	public Publie() {
		
	}
	
	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	public int getIdJeu() {
		return idJeu;
	}

	public void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}
	
	public int getIdPublication() {
		return idPublication;
	}

	public void setIdPublication(int idPublication) {
		this.idPublication = idPublication;
	}
	
	public boolean equals(Object u) {
		return (idJoueur == ((Publie) u).getIdJoueur() && idPublication == ((Publie) u).getIdPublication());
	}

	public String toString() {
		return idJoueur + ": " + idPublication;
	}

}
