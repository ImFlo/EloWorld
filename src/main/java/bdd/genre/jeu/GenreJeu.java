package bdd.genre.jeu;

public class GenreJeu {
	private int idJeu;
	private int idCategorie;


	public GenreJeu(int idJeu, int idCategorie) {
		this.idCategorie = idCategorie;
		this.idJeu = idJeu;
	}

	public GenreJeu() {
		
	}
	
	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public int getIdJeu(){
		return idJeu;
	}
	
	public void setIdJeu(int idJeu){
		this.idJeu = idJeu;
	}

	public String toString() {
		return idJeu + ": " + idCategorie;
	}

}