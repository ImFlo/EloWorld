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
import java.util.List;

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
	@Path("/create:{pseudo}:{mdp}:{email}:{nom}:{prenom}")
	@Produces("application/json")
	public String createJoueur(@PathParam("pseudo") String pseudo, @PathParam("mdp") String mdp,
													@PathParam("email") String email, @PathParam("nom") String nom,
													@PathParam("prenom") String prenom){
		try{
		int id = dao.insert(prenom, nom, pseudo, mdp, email);
		System.out.println("patate= " + id);
		}catch(Exception e){
			return "not ok";
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
	public List<Joueur> getInstanceof(){
		
		return dao.getAll();
	}

	@GET
	@Path("/{log}&{mdp}")
	public String  getJoueurCorresponding(@PathParam("log") String login,
																			 @PathParam("mdp") String pwd){
		Joueur j = dao.findJoueur(login, pwd);
		if(j == null)
			throw new WebApplicationException(405);
		return j.getId() + "";
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Joueur getJoueur(@PathParam("id") int id) {
		Joueur out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}
