package bdd.publication;

import java.sql.Date;

public class Publication {
	private int id = 0;
	private String texte;
	private String date;


	public Publication(int id, String texte, String date) {
		this.id = id;
		this.texte = texte;
		this.date = date;
	}

	public Publication() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte(){
		return texte;
	}
	
	public void setTexte(String texte){
		this.texte = texte;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public boolean equals(Object u) {
		return id == ((Publication) u).getId();
	}

	public String toString() {
		return id + ": " + texte;
	}

}
