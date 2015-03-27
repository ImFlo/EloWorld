package bdd.ami;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;
import bdd.joueur.*;
import java.util.List;

@Path("/amidb")
@Produces(MediaType.APPLICATION_JSON)
public class AmiDBRessource {
	private static AmiDao dao = App.dbi.open(AmiDao.class);

	public AmiDBRessource() {
		try {
			dao.createAmiTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	@Path("/{id1}&{id2}")
	public String createAmi(@PathParam("id1") int id1, @PathParam("id2") int id2) {
		int id = dao.insert(id1, id2);
		return id + "";
	}

	@GET
	@Path("/{j1}&{j2}")
	public String areFriend(@PathParam("j1") int idj1, @PathParam("j2") int idj2){
		int out = dao.areFriend(idj1, idj2);
		return (out > 0) + "";
	}

	@GET
	@Path("/{idJoueur1}")
	public List<Joueur> getAmi(@PathParam("idJoueur1") int idJoueur1) {
		List<Joueur>  out = dao.getFriendList(idJoueur1);
		return out;
	}
}
