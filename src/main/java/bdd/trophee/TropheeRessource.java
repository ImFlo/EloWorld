package bdd.trophee;

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

@Path("/trophee")
@Produces(MediaType.APPLICATION_JSON)
public class TropheeRessource {
	private static Map<Integer, Trophee> trophees = new HashMap<Integer, Trophee>();
	
	@POST
	public Trophee createTrophee(Trophee trophee) {
		int id = trophees.size();
		trophee.setId(id+1);
		trophees.put(trophee.getId(), trophee);
		return trophee;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteJeu(@PathParam("id") Integer id) {
		if (trophees.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Trophee find(String nom) {
		Trophee out = null;
		for (Trophee trophee : trophees.values()) {
			if (trophee.getNom().equals(nom)) {
				return trophee;
			}
		}
		return out;
	}
	protected Trophee find(int id) {
		return trophees.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateTrophee(@PathParam("id") int id, 
			Trophee trophee) {
		Trophee oldTrophee = find(id);
		System.out.println("Should update trophee with id: "+id
				+" ("+oldTrophee+") to " +trophee);
		if (trophee == null) {
			throw new WebApplicationException(404);
		}
		oldTrophee.setNom(trophee.getNom());
		oldTrophee.setDescription(trophee.getDescription());
		return Response.status(200).entity(oldTrophee).build();
	}
	
	@GET
	@Path("/{nom}")
	public Trophee getTrophee(@PathParam("nom") String nom ) {
		Trophee out = find(nom);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Trophee> getTrophees(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Trophee>(trophees.values());
	}

}
