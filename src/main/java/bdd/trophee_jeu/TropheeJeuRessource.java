package bdd.trophee_jeu;

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

@Path("/trophee_jeu")
@Produces(MediaType.APPLICATION_JSON)
public class TropheeJeuRessource {
	private static Map<Integer, ArrayList<Integer>> tj = new HashMap<Integer, ArrayList<Integer>>();
	
	@POST
	public TropheeJeu createTropheeJeu(TropheeJeu tropheeJeu) {
		if(!tj.containsKey(tropheeJeu.getIdJeu()))
			tj.put(tropheeJeu.getIdJeu(), new ArrayList<Integer>());
		tj.get(tropheeJeu.getIdJeu()).add(tropheeJeu.getIdTrophee());
		return tropheeJeu;
	}
	
	@DELETE
	@Path("{idJeu}/{idTrophee}")
	public Response deleteTropheeJeu(@PathParam("idJeu") Integer idJeu,
			@PathParam("idTrophee") Integer idTrophee) {
		if (tj.containsKey(idJeu) && tj.get(idJeu).contains(idTrophee)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected ArrayList<Integer> find(int idJeu) {
		ArrayList<Integer> out = null;
		if(tj.containsKey(idJeu))
				return tj.get(idJeu);
		return out;
	}
	
	@GET
	@Path("/{idJeu}")
	public ArrayList<Integer> getTropheeJeu(@PathParam("idJeu") int idJeu ) {
		ArrayList<Integer> out = find(idJeu);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}

}
