package bdd.possede.jeu;

public class PossedeJeu {
	private int idJoueur;
	private int idJeu;


	public PossedeJeu(int idJoueur, int idJeu) {
		this.idJoueur = idJoueur;
		this.idJeu = idJeu;
	}

	public PossedeJeu() {
		
	}
	
	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public int getIdJeu(){
		return idJeu;
	}
	
	public void setIdJeu(int idJeu){
		this.idJeu = idJeu;
	}
	
	public boolean equals(Object u) {
		return (idJoueur == ((PossedeJeu) u).getIdJoueur() && idJeu == ((PossedeJeu) u).getIdJeu());
	}

	public String toString() {
		return idJoueur + ": " + idJeu;
	}

}
