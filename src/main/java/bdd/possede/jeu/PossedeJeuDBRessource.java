package bdd.possede.jeu;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import bdd.jeu.*;

import java.util.*;

import bdd.App;

@Path("/possede_jeudb")
@Produces(MediaType.APPLICATION_JSON)
public class PossedeJeuDBRessource {
	private static PossedeJeuDao dao = App.dbi.open(PossedeJeuDao.class);

	public PossedeJeuDBRessource() {
		try {
			dao.createPossedeJeuTable();
		} catch (Exception e) {
			System.out.println("Table déjà là !");
		}
	}
	
	@POST
	@Path("/insert:{idPlayer}:{idGame}")
	public PossedeJeu createPossedeJeu(@PathParam("idPlayer") int idPlayer, @PathParam("idGame") int idGame) {
		int id = dao.insert(idPlayer, idGame);
		return new PossedeJeu(idPlayer, idGame);
	}

	@GET
	@Path("/{idJoueur}")
	public List<Jeu> getPossedeJeu(@PathParam("idJoueur") int idJoueur) {
		List<Jeu> out = dao.getJeuDe(idJoueur);
		return out;
	}
	
	@GET
	@Path("/{idJoueur}:{idJeu}")
	public int getElo(@PathParam("idJoueur") int idJoueur, @PathParam("idJeu") int idJeu){
		int out = 0;
		try{
			out = dao.getElo(idJoueur, idJeu);
		}
		catch(Exception e){
			throw new WebApplicationException(404);
		}
		return out;
	}
}
