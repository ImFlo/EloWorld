package bdd.ami;

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

@Path("/ami")
@Produces(MediaType.APPLICATION_JSON)
public class AmiRessource {
	private static Map<Integer, ArrayList<Integer>> amis = new HashMap<>();
	
	@POST
	public Ami createAmi(Ami ami) {
		if(!amis.containsKey(ami.getIdJoueur1()))
			amis.put(ami.getIdJoueur1(), new ArrayList<Integer>());
		amis.get(ami.getIdJoueur1()).add(ami.getIdJoueur2());
		return ami;
	}
	
	@DELETE
	@Path("{idJoueur1}/{idJoueur2}")
	public Response deleteAmi(@PathParam("idJoueur1") Integer idJoueur1,
			@PathParam("idJoueur2") Integer idJoueur2) {
		if (amis.containsKey(idJoueur1) && amis.get(idJoueur1).contains(idJoueur2)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected ArrayList<Integer> find(int idJoueur1) {
		ArrayList<Integer> out = null;
		if(amis.containsKey(idJoueur1))
				return amis.get(idJoueur1);
		return out;
	}
	
	@GET
	@Path("/{idJoueur1}")
	public ArrayList<Integer> getAmi(@PathParam("idJoueur1") int idJoueur1 ) {
		ArrayList<Integer> out = find(idJoueur1);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}

}
