package bdd.trophee;

public class Trophee {
	private int id = 0;
	private String nom;
	private String description;


	public Trophee(int id, String nom, String description) {
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public Trophee() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription(){
		return description;
	}
	
	public void setDescription(String Description){
		this.description = description;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean equals(Object u) {
		return id == ((Trophee) u).getId();
	}

	public String toString() {
		return id + ": " + nom;
	}

}
