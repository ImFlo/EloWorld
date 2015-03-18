package bdd;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;
import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

import bdd.ami.AmiDBRessource;
import bdd.ami.AmiRessource;
import bdd.categorie.CategorieDBRessource;
import bdd.categorie.CategorieRessource;
import bdd.genre.jeu.GenreJeuDBRessource;
import bdd.genre.jeu.GenreJeuRessource;
import bdd.jeu.JeuDBRessource;
import bdd.jeu.JeuRessource;
import bdd.joueur.JoueurDBRessource;
import bdd.joueur.JoueurRessource;
import bdd.possede.jeu.PossedeJeuDBRessource;
import bdd.possede.jeu.PossedeJeuRessource;
import bdd.possede.trophee.PossedeTropheeDBRessource;
import bdd.possede.trophee.PossedeTropheeRessource;
import bdd.publication.PublicationDBRessource;
import bdd.publication.PublicationRessource;
import bdd.publie.PublieDBRessource;
import bdd.publie.PublieRessource;
import bdd.trophee.TropheeDBRessource;
import bdd.trophee.TropheeRessource;
import bdd.trophee_jeu.TropheeJeuDBRessource;
import bdd.trophee_jeu.TropheeJeuRessource;

@ApplicationPath("/v1/")
public class App extends Application {
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	s.add(JoueurRessource.class);
    	s.add(JeuRessource.class);
    	s.add(PublicationRessource.class);
    	s.add(CategorieRessource.class);
    	s.add(TropheeRessource.class);
    	s.add(PossedeJeuRessource.class);
    	s.add(PossedeTropheeRessource.class);
    	s.add(TropheeJeuRessource.class);
    	s.add(AmiRessource.class);
    	s.add(PublieRessource.class);
    	s.add(LoggingFilter.class);
    	s.add(JoueurDBRessource.class);
    	s.add(JeuDBRessource.class);
    	s.add(PublicationDBRessource.class);
    	s.add(CategorieDBRessource.class);
    	s.add(TropheeDBRessource.class);
    	s.add(PossedeJeuDBRessource.class);
    	s.add(PossedeTropheeDBRessource.class);
    	s.add(TropheeJeuDBRessource.class);
    	s.add(AmiDBRessource.class);
    	s.add(PublieDBRessource.class);
    	s.add(GenreJeuDBRessource.class);
    	s.add(GenreJeuRessource.class);
    	return s;
    }
    
    public static DBI dbi;
	static {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:"+System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"data.db");
		dbi = new DBI(ds);
    }
}
