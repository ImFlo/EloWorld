package bdd.joueur;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

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
	public Joueur createJoueur(Joueur joueur) {
		int id = dao.insert(joueur.getPrenom(), joueur.getNom(), joueur.getPseudo(), joueur.getMdp(),
				joueur.getEmail(), joueur.getSteamID(), joueur.getRiotID());
		joueur.setId(id);
		return joueur;
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
