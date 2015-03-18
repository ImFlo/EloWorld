package bdd.publie;

public class Publie {
	private int idJoueur;
	private int idPublication;


	public Publie(int idJoueur, int idPublication) {
		this.idJoueur = idJoueur;
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
