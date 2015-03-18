package bdd.trophee_jeu;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;

@Path("/trophee_jeudb")
@Produces(MediaType.APPLICATION_JSON)
public class TropheeJeuDBRessource {
	private static TropheeJeuDao dao = App.dbi.open(TropheeJeuDao.class);

	public TropheeJeuDBRessource() {
		try {
			dao.createTropheeJeuTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public TropheeJeu createTropheeJeu(TropheeJeu tropheeJeu) {
		int id = dao.insert(tropheeJeu.getIdJeu(), tropheeJeu.getIdTrophee());
		return tropheeJeu;
	}

	@GET
	@Path("/{idJeu}")
	public TropheeJeu getTropheeJeu(@PathParam("idJeu") int idJeu) {
		TropheeJeu out = dao.findById(idJeu);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}