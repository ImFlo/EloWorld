package bdd;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.filter.LoggingFilter;
import org.skife.jdbi.v2.DBI;
import org.sqlite.SQLiteDataSource;

import bdd.jeu.JeuDBRessource;
import bdd.jeu.JeuRessource;
import bdd.joueur.JoueurDBRessource;
import bdd.joueur.JoueurRessource;
import bdd.publication.Publication;
import bdd.publication.PublicationDBRessource;
import bdd.publication.PublicationRessource;

@ApplicationPath("/v1/")
public class App extends Application {
    @Override
    public Set<Class<?>> getClasses() {
    	Set<Class<?>> s = new HashSet<Class<?>>();
    	s.add(JoueurRessource.class);
    	s.add(JeuRessource.class);
    	s.add(PublicationRessource.class);
    	s.add(LoggingFilter.class);
    	s.add(JoueurDBRessource.class);
    	s.add(JeuDBRessource.class);
    	s.add(PublicationDBRessource.class);
    	return s;
    }
    
    public static DBI dbi;
	static {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl("jdbc:sqlite:"+System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"data.db");
		dbi = new DBI(ds);
    }
}
