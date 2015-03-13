package bdd.publication;

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
public class PublicationDBRessource {
	private static PublicationDao dao = App.dbi.open(PublicationDao.class);

	public PublicationDBRessource() {
		try {
			dao.createPublicationTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public Publication createPublication(Publication pub) {
		int id = dao.insert(pub.getTexte(), pub.getDate());
		pub.setId(id);
		return pub;
	}

	@GET
	@Path("/{id}")
	public Publication getPublication(@PathParam("id") int id) {
		Publication out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}