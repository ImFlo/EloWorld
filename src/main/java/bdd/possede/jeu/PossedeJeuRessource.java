package bdd.possede.jeu;

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

@Path("/possede_jeu")
@Produces(MediaType.APPLICATION_JSON)
public class PossedeJeuRessource {
	private static Map<Integer, ArrayList<Integer>> possede = new HashMap<>();
	
	@POST
	public PossedeJeu createPossedeJeu(PossedeJeu possedeJeu) {
		if(!possede.containsKey(possedeJeu.getIdJoueur()))
			possede.put(possedeJeu.getIdJoueur(), new ArrayList<Integer>());
		possede.get(possedeJeu.getIdJoueur()).add(possedeJeu.getIdJeu());
		return possedeJeu;
	}
	
	@DELETE
	@Path("{idJoueur}/{idJeu}")
	public Response deletePossedeJeu(@PathParam("idJoueur") Integer idJoueur,
			@PathParam("idJeu") Integer idJeu) {
		if (possede.containsKey(idJoueur) && possede.get(idJoueur).contains(idJeu)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected ArrayList<Integer> find(int idJoueur) {
		ArrayList<Integer> out = null;
		if(possede.containsKey(idJoueur))
				return possede.get(idJoueur);
		return out;
	}
	
	@GET
	@Path("/{idJoueur}")
	public ArrayList<Integer> getPossedeJeu(@PathParam("idJoueur") int idJoueur ) {
		ArrayList<Integer> out = find(idJoueur);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}

}
