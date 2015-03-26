package bdd.ami;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;

@Path("/amidb")
@Produces(MediaType.APPLICATION_JSON)
public class AmiDBRessource {
	private static AmiDao dao = App.dbi.open(AmiDao.class);

	public AmiDBRessource() {
		try {
			dao.createAmiTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@GET
	@Path("/{id1}&{id2}")
	public int createAmi(@PathParam("id1") int id1, @PathParam("id2") int id2) {
		int id = dao.insert(id1, id2);
		return id;
	}

	@GET
	@Path("/{idJoueur1}")
	public Ami getAmi(@PathParam("idJoueur1") int idJoueur1) {
		Ami out = dao.findById(idJoueur1);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}
