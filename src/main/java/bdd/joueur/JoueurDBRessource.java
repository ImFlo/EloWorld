package bdd.joueur;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.lang.Exception;


import bdd.App;

@Path("/joueurdb")
@Produces(MediaType.APPLICATION_JSON)
public class JoueurDBRessource {
	private static JoueurDao dao = App.dbi.open(JoueurDao.class);

	public JoueurDBRessource() {
		try {
			dao.createJoueurTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded") 
	public String createJoueur(@FormParam("pseudo") String pseudo, @FormParam("mdp") String mdp,
													@FormParam("email") String email, @FormParam("nom") String nom,
													@FormParam("prenom") String prenom){
		try{
			int id = dao.insert(prenom, nom, pseudo, mdp, email);
		}catch(Exception e){
				return e.toString();
		}
		return "ok";
	}


	@POST
	public Joueur createJoueur(/*@FormParam("joueur") */Joueur joueur) {
		int id = dao.insert(joueur.getPrenom(), joueur.getNom(), joueur.getPseudo(), joueur.getMdp(),
				joueur.getEmail());
		joueur.setId(id);
		return joueur;
	}

	@GET
	public Joueur getInstanceof(){
		Joueur j = new Joueur();
		j.setPseudo("patate");
		j.setMdp("patate");
		j.setEmail("patate@atate.patate");
		return j;
	}

	@GET
	@Path("/{log}&{mdp}")
	public Joueur getJoueurCorresponding(@PathParam("log") String login,
																			 @PathParam("mdp") String pwd){
		Joueur j = dao.findJoueur(login, pwd);
		if(j == null)
			throw new WebApplicationException(404);
		return j;
	}

	@GET
	@Path("/{id}")
	public Joueur getJoueur(@PathParam("id") int id) {
		Joueur out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}
