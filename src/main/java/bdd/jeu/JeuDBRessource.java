package bdd.jeu;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.App;

@Path("/jeudb")
@Produces(MediaType.APPLICATION_JSON)
public class JeuDBRessource {
	private static JeuDao dao = App.dbi.open(JeuDao.class);

	public JeuDBRessource() {
		try {
			dao.createJeuTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	public Jeu createJeu(Jeu jeu) {
		int id = dao.insert(jeu.getAppID(), jeu.getNom());
		jeu.setId(id);
		return jeu;
	}

	@GET
	@Path("/{id}")
	public Jeu getJeu(@PathParam("id") int id) {
		Jeu out = dao.findById(id);
		if (out == null) {
			throw new WebApplicationException(404);
		}
		return out;
	}
}