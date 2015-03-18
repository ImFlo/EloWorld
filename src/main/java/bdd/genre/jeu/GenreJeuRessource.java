package bdd.genre.jeu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/genre_jeu")
@Produces(MediaType.APPLICATION_JSON)
public class GenreJeuRessource {
	private static Map<Integer, ArrayList<Integer>> genre = new HashMap<Integer, ArrayList<Integer>>();
	
	@POST
	public GenreJeu createGenreJeu(GenreJeu genreJeu) {
		if(!genre.containsKey(genreJeu.getIdJeu()))
			genre.put(genreJeu.getIdJeu(), new ArrayList<Integer>());
		genre.get(genreJeu.getIdJeu()).add(genreJeu.getIdJeu());
		return genreJeu;
	}
	
	@DELETE
	@Path("{idJeu}/{idCategorie}")
	public Response deleteGenreJeu(@PathParam("idJeu") Integer idJeu,
			@PathParam("idCategorie") Integer idCategorie) {
		if (genre.containsKey(idJeu) && genre.get(idJeu).contains(idCategorie)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected ArrayList<Integer> find(int idJeu) {
		ArrayList<Integer> out = null;
		if(genre.containsKey(idJeu))
				return genre.get(idJeu);
		return out;
	}
	
	@GET
	@Path("/{idJeu}")
	public ArrayList<Integer> getGenreJeu(@PathParam("idJeu") int idJeu ) {
		ArrayList<Integer> out = find(idJeu);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}

}
