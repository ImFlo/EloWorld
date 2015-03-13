package bdd.jeu;

public class Jeu {
	private int id = 0;
	private String appID;
	private String nom;


	public Jeu(int id, String appID, String nom) {
		this.id = id;
		this.appID = appID;
		this.nom = nom;
	}

	public Jeu() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppID(){
		return appID;
	}
	
	public void setAppID(String appID){
		this.appID = appID;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean equals(Object u) {
		return id == ((Jeu) u).getId();
	}

	public String toString() {
		return id + ": " + nom;
	}

}
