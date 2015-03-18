package bdd.categorie;

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

@Path("/categorie")
@Produces(MediaType.APPLICATION_JSON)
public class CategorieRessource {
	private static Map<Integer, Categorie> cats = new HashMap<Integer, Categorie>();
	
	@POST
	public Categorie createCategorie(Categorie cat) {
		int id = cats.size();
		cat.setId(id+1);
		cats.put(cat.getId(), cat);
		return cat;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteJeu(@PathParam("id") Integer id) {
		if (cats.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Categorie find(String nom) {
		Categorie out = null;
		for (Categorie cat : cats.values()) {
			if (cat.getNom().equals(nom)) {
				return cat;
			}
		}
		return out;
	}
	protected Categorie find(int id) {
		return cats.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateCategorie(@PathParam("id") int id, 
			Categorie cat) {
		Categorie oldCat = find(id);
		System.out.println("Should update categorie with id: "+id
				+" ("+oldCat+") to " +cat);
		if (cat == null) {
			throw new WebApplicationException(404);
		}
		oldCat.setNom(cat.getNom());
		return Response.status(200).entity(oldCat).build();
	}
	
	@GET
	@Path("/{nom}")
	public Categorie getCategorie(@PathParam("nom") String nom ) {
		Categorie out = find(nom);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Categorie> getJeux(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Categorie>(cats.values());
	}

}
