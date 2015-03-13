package bdd.joueur;

public class Joueur {
	private int id = 0;
	private String prenom;
	private String nom;
	private String pseudo;
	private String mdp;
	private String email;
	private String steamID;
	private String riotID;
	

	public Joueur(int id, String prenom, String nom, String pseudo, String mdp,
					String email, String steamID, String riotID) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.email = email;
		this.steamID = steamID;
		this.riotID = riotID;
	}

	public Joueur() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom(){
		return prenom;
	}
	
	public void setPrenom(String prenom){
		this.prenom = prenom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getMdp(){
		return mdp;
	}
	
	public void setMdp(String mdp){
		this.mdp = mdp;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getSteamID(){
		return steamID;
	}
	
	public void setSteamID(String steamID){
		this.steamID = steamID;
	}
	
	public String getRiotID(){
		return riotID;
	}
	
	public void setRiotID(String riotID){
		this.riotID = riotID;
	}
	
	public boolean equals(Object u) {
		return id == ((Joueur) u).getId();
	}

	public String toString() {
		return id + ": " + nom;
	}

}
