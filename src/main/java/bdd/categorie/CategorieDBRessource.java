package bdd.categorie;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;

@Path("/categoriedb")
@Produces(MediaType.APPLICATION_JSON)
public class CategorieDBRessource {
	private static CategorieDao dao = App.dbi.open(CategorieDao.class);

	public CategorieDBRessource() {
		try {
			dao.createCategorieTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public Categorie createCategorie(Categorie cat) {
		int id = dao.insert(cat.getNom());
		cat.setId(id);
		return cat;
	}

	@GET
	@Path("/{id}")
	public Categorie getCategorie(@PathParam("id") int id) {
		Categorie out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}