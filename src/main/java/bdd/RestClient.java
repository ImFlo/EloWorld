package bdd;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

public class RestClient {
	
	public String getUrlAsString (String url) {
		return ClientBuilder.newClient()//
        .target(url)
        .request()
        .get(String.class);
	}
	
	public List<Joueur> getUrlAsJoueur (String url) {
		return ClientBuilder.newClient()//
        .target(url)
        .request()
        .get(new GenericType<List<Joueur>>(){});
	}
	
	public Joueur addJoueur (Joueur joueur, String url) {
		Entity<Joueur> joueurEntity = Entity.entity(joueur, MediaType.APPLICATION_JSON);
		
		return ClientBuilder.newClient()
				.target(url)
				.request()
				.post(joueurEntity)
				.readEntity(Joueur.class);
	}
}
