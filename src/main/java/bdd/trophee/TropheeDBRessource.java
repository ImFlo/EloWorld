package bdd.trophee;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;

@Path("/jeudb")
@Produces(MediaType.APPLICATION_JSON)
public class TropheeDBRessource {
	private static TropheeDao dao = App.dbi.open(TropheeDao.class);

	public TropheeDBRessource() {
		try {
			dao.createTropheeTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public Trophee createTrophee(Trophee trophee) {
		int id = dao.insert(trophee.getNom(), trophee.getDescription());
		trophee.setId(id);
		return trophee;
	}

	@GET
	@Path("/{id}")
	public Trophee getTrophee(@PathParam("id") int id) {
		Trophee out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}