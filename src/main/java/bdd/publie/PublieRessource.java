package bdd.publie;

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

@Path("/publie")
@Produces(MediaType.APPLICATION_JSON)
public class PublieRessource {
	private static Map<Integer, ArrayList<Integer>> pubs = new HashMap<Integer, ArrayList<Integer>>();
	
	@POST
	public Publie createPublie(Publie publie) {
		if(!pubs.containsKey(publie.getIdJoueur()))
			pubs.put(publie.getIdJoueur(), new ArrayList<Integer>());
		pubs.get(publie.getIdJoueur()).add(publie.getIdPublication());
		return publie;
	}
	
	@DELETE
	@Path("{idJoueur}/{idPublication}")
	public Response deletePublie(@PathParam("idJoueur") Integer idJoueur,
			@PathParam("idPublication") Integer idPublication) {
		if (pubs.containsKey(idJoueur) && pubs.get(idJoueur).contains(idPublication)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected ArrayList<Integer> find(int idJoueur) {
		ArrayList<Integer> out = null;
		if(pubs.containsKey(idJoueur))
				return pubs.get(idJoueur);
		return out;
	}
	
	@GET
	@Path("/{idJoueur}")
	public ArrayList<Integer> getPublie(@PathParam("idJoueur") int idJoueur ) {
		ArrayList<Integer> out = find(idJoueur);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}

}
