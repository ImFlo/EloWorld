package bdd.trophee_jeu;

public class TropheeJeu {
	private int idJeu;
	private int idTrophee;


	public TropheeJeu(int idJeu, int idTrophee) {
		this.idJeu = idJeu;
		this.idTrophee = idTrophee;
	}

	public TropheeJeu() {
		
	}
	
	public int getIdJeu() {
		return idJeu;
	}

	public void setIdJeu(int idJeu) {
		this.idJeu = idJeu;
	}

	public int getIdTrophee(){
		return idTrophee;
	}
	
	public void setIdTrophee(int idTrophee){
		this.idTrophee = idTrophee;
	}
	
	public boolean equals(Object u) {
		return (idJeu == ((TropheeJeu) u).getIdJeu() && idTrophee == ((TropheeJeu) u).getIdTrophee());
	}

	public String toString() {
		return idJeu + ": " + idTrophee;
	}

}
