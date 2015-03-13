package bdd.categorie;

public class Categorie {
	private int id = 0;
	private String nom;


	public Categorie(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Categorie() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean equals(Object u) {
		return id == ((Categorie) u).getId();
	}

	public String toString() {
		return id + ": " + nom;
	}

}
