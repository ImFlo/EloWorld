package bdd.jeu;

public class Jeu {
	private int id = 0;
	private String appID;
	private String nom;
	private String image;
	private String lien;


	public Jeu(int id, String appID, String nom, String image, String lien) {
		this.id = id;
		this.appID = appID;
		this.nom = nom;
		this.image = image;
		this.lien = lien;
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
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String image){
		this.image = image;
	}
	
	public String getLien(){
		return lien;
	}
	
	public void setLien(String lien){
		this.lien = lien;
	}
	
	public boolean equals(Object u) {
		return id == ((Jeu) u).getId();
	}

	public String toString() {
		return id + ": " + nom;
	}

}
