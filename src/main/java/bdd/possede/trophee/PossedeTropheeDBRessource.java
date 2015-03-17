package bdd.possede.trophee;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;

@Path("/possede_tropheedb")
@Produces(MediaType.APPLICATION_JSON)
public class PossedeTropheeDBRessource {
	private static PossedeTropheeDao dao = App.dbi.open(PossedeTropheeDao.class);

	public PossedeTropheeDBRessource() {
		try {
			dao.createPossedeTropheeTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public PossedeTrophee createPossedeTrophee(PossedeTrophee possede) {
		int id = dao.insert(possede.getIdJoueur(),possede.getIdTrophee());
		return possede;
	}

	@GET
	@Path("/{idJoueur}")
	public PossedeTrophee getPossedeTrophee(@PathParam("idJoueur") int idJoueur) {
		PossedeTrophee out = dao.findById(idJoueur);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}