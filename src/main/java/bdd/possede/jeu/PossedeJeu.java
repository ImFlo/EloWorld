package bdd.possede.jeu;

public class PossedeJeu {
	private int idJoueur;
	private int idJeu;
	private int elo;


	public PossedeJeu(int idJoueur, int idJeu) {
		this.idJoueur = idJoueur;
		this.idJeu = idJeu;
		this.elo = 1200;
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
	
	public int getElo(){
		return elo;
	}
	
	public void setElo(int elo){
		this.elo=elo;
	}
	
	public boolean equals(Object u) {
		return (idJoueur == ((PossedeJeu) u).getIdJoueur() && idJeu == ((PossedeJeu) u).getIdJeu());
	}

	public String toString() {
		return idJoueur + ": " + idJeu;
	}

}
