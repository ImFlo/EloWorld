package bdd.publie;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;

@Path("/publiedb")
@Produces(MediaType.APPLICATION_JSON)
public class PublieDBRessource {
	private static PublieDao dao = App.dbi.open(PublieDao.class);

	public PublieDBRessource() {
		try {
			dao.createPublieTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public Publie createPublie(Publie publie) {
		int id = dao.insert(publie.getIdJoueur(), publie.getIdJeu(), publie.getIdPublication());
		return publie;
	}

	@GET
	@Path("/{idJoueur}")
	public Publie getPublie(@PathParam("idJoueur") int idJoueur) {
		Publie out = dao.findById(idJoueur);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}