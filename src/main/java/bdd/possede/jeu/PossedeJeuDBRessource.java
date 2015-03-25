package bdd.possede.jeu;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

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
	public PossedeJeu createPossedeJeu(PossedeJeu possedeJeu) {
		int id = dao.insert(possedeJeu.getIdJoueur(), possedeJeu.getIdJeu());
		return possedeJeu;
	}

	@GET
	@Path("/{idJoueur}")
	public String getPossedeJeu(@PathParam("idJoueur") int idJoueur) {
		List<String> out = dao.getJeuDe(idJoueur);
		System.out.println(out.toString());
		if (out == null) {
			throw new WebApplicationException(404);
		}
		String str = "";
		if(out.size() > 0){
			for(String s : out){
				str += s + ";";
			}
			str = str.substring(0, str.length()-1);
		}
		return str;
	}
}
