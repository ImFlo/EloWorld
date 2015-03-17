package bdd.possede.trophee;

public class PossedeTrophee {
	private int idJoueur;
	private int idTrophee;

	public PossedeTrophee(int idJoueur, int idTrophee) {
		this.idJoueur = idJoueur;
		this.idTrophee = idTrophee;
	}

	public PossedeTrophee() {
		
	}
	
	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	public int getIdTrophee() {
		return idTrophee;
	}

	public void setIdTrophee(int idTrophee) {
		this.idTrophee = idTrophee;
	}
	
	public boolean equals(Object u) {
		return (idJoueur == ((PossedeTrophee) u).getIdJoueur() && idTrophee == ((PossedeTrophee) u).getIdTrophee());
	}

	public String toString() {
		return idJoueur + ": " + idTrophee;
	}

}
