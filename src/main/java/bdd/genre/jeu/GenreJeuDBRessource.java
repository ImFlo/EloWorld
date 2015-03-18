package bdd.genre.jeu;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;

@Path("/genre_jeudb")
@Produces(MediaType.APPLICATION_JSON)
public class GenreJeuDBRessource {
	private static GenreJeuDao dao = App.dbi.open(GenreJeuDao.class);

	public GenreJeuDBRessource() {
		try {
			dao.createGenreJeuTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public GenreJeu createGenreJeu(GenreJeu genreJeu) {
		int id = dao.insert(genreJeu.getIdJeu(), genreJeu.getIdCategorie());
		return genreJeu;
	}

	@GET
	@Path("/{idJeu}")
	public GenreJeu getGenreJeu(@PathParam("idJeu") int idJeu) {
		GenreJeu out = dao.findById(idJeu);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}