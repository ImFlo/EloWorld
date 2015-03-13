package bdd.publication;

import java.sql.Date;
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

@Path("/joueur")
@Produces(MediaType.APPLICATION_JSON)
public class PublicationRessource {
	private static Map<Integer, Publication> pubs = new HashMap<>();
	
	@POST
	public Publication createPublication(Publication pub) {
		int id = pubs.size();
		pub.setId(id+1);
		pubs.put(pub.getId(), pub);
		return pub;
	}
	
	@DELETE
	@Path("{id}")
	public Response deletePublication(@PathParam("id") Integer id) {
		if (pubs.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Publication find(Date date) {
		Publication out = null;
		for (Publication pub : pubs.values()) {
			if (pub.getDate().equals(date)) {
				return pub;
			}
		}
		return out;
	}
	protected Publication find(int id) {
		return pubs.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updatePublication(@PathParam("id") int id, 
			Publication pub) {
		Publication oldPub = find(id);
		System.out.println("Should update user with id: "+id
				+" ("+oldPub+") to " +pub);
		if (pub == null) {
			throw new WebApplicationException(404);
		}
		oldPub.setTexte(pub.getTexte());
		oldPub.setDate(pub.getDate());
		return Response.status(200).entity(oldPub).build();
	}
	
	@GET
	@Path("/{id}")
	public Publication getJeu(@PathParam("id") int id ) {
		Publication out = find(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Publication> getJeux(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Publication>(pubs.values());
	}

}
