package bdd;

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
public class JeuRessource {
	private static Map<Integer, Jeu> jeux = new HashMap<>();
	
	@POST
	public Jeu createJeu(Jeu jeu) {
		int id = jeux.size();
		jeu.setId(id+1);
		jeux.put(jeu.getId(), jeu);
		return jeu;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteJeu(@PathParam("id") Integer id) {
		if (jeux.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Jeu find(String nom) {
		Jeu out = null;
		for (Jeu jeu : jeux.values()) {
			if (jeu.getNom().equals(nom)) {
				return jeu;
			}
		}
		return out;
	}
	protected Jeu find(int id) {
		return jeux.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateJeu(@PathParam("id") int id, 
			Jeu jeu) {
		Jeu oldJeu = find(id);
		System.out.println("Should update user with id: "+id
				+" ("+oldJeu+") to " +jeu);
		if (jeu == null) {
			throw new WebApplicationException(404);
		}
		oldJeu.setAppID(jeu.getAppID());
		oldJeu.setNom(jeu.getNom());
		return Response.status(200).entity(oldJeu).build();
	}
	
	@GET
	@Path("/{nom}")
	public Jeu getJeu(@PathParam("nom") String nom ) {
		Jeu out = find(nom);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Jeu> getJeux(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Jeu>(jeux.values());
	}

}
