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
public class JoueurRessource {
	private static Map<Integer, Joueur> joueurs = new HashMap<>();
	
	@POST
	public Joueur createJoueur(Joueur joueur) {
		int id = joueurs.size();
		joueur.setId(id+1);
		joueurs.put(joueur.getId(), joueur);
		return joueur;
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteJoueur(@PathParam("id") Integer id) {
		if (joueurs.containsKey(id)) {
			return Response.accepted().status(Status.ACCEPTED).build();
		}
	    return Response.accepted().status(Status.NOT_FOUND).build();
	}
	
	protected Joueur find(String pseudo) {
		Joueur out = null;
		for (Joueur joueur : joueurs.values()) {
			if (joueur.getPseudo().equals(pseudo)) {
				return joueur;
			}
		}
		return out;
	}
	protected Joueur find(int id) {
		return joueurs.get(id);
	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
	public Response updateJoueur(@PathParam("id") int id, 
			Joueur joueur) {
		Joueur oldJoueur = find(id);
		System.out.println("Should update user with id: "+id
				+" ("+oldJoueur+") to " +joueur);
		if (joueur == null) {
			throw new WebApplicationException(404);
		}
		oldJoueur.setPrenom(joueur.getPrenom());
		oldJoueur.setNom(joueur.getNom());
		oldJoueur.setPseudo(joueur.getPseudo());
		oldJoueur.setMdp(joueur.getMdp());
		oldJoueur.setEmail(joueur.getEmail());
		oldJoueur.setSteamID(joueur.getSteamID());
		oldJoueur.setRiotID(joueur.getRiotID());
		return Response.status(200).entity(oldJoueur).build();
	}
	
	@GET
	@Path("/{pseudo}")
	public Joueur getJoueur(@PathParam("pseudo") String pseudo ) {
		Joueur out = find(pseudo);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
	
	@GET
	public List<Joueur> getJoueurs(@DefaultValue("10") @QueryParam("limit") int limit) {
		return new ArrayList<Joueur>(joueurs.values());
	}

}
