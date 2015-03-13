package login;

import bdd.*;
import bdd.joueur.Joueur;
import bdd.joueur.JoueurDao;

import java.util.HashMap;
import java.util.Random;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 *
 * @author sicchiof
 */
@Path("/joueur")
@Produces(MediaType.APPLICATION_JSON)
public class Login {

    private static HashMap<String, Joueur> joueurConnecte = new HashMap<String, Joueur>();
    private static JoueurDao dao = App.dbi.open(JoueurDao.class);

    public Login() {
        try {
            dao.createJoueurTable();
        } catch (Exception e) {
            System.out.println("Table déjà là !");
        }
    }

    @GET
    @Path("/connect={name}&{mdp}")
    public String connect(@PathParam("name") String pseudo, @PathParam("pwd") String pwd) {
        Joueur out = dao.findJoueur(pseudo, pwd);
        if (out == null) {
            throw new WebApplicationException(404);
        }
        String key = new Random().nextInt() + "";
        while (joueurConnecte.containsKey(key)) {
            key = new Random().nextInt() + "";
        }
        joueurConnecte.put(key, out);
        return key;
    }
    
    @POST
    @Path("=")
    public boolean isConnected(@FormParam("id") String id){
        return joueurConnecte.containsKey(id);
    }
}
