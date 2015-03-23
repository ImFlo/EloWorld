package bdd.jeu;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import bdd.joueur.Joueur;

public interface JeuDao {

    @SqlUpdate("create table jeu (id integer primary key autoincrement, appID text not null, nom text not null)")
    void createJeuTable();

    @SqlUpdate("insert into jeu (appID, nom) "
            + "values (:appID, :nom)")
    @GetGeneratedKeys
    int insert(@Bind("appID") String appID, @Bind("nom") String nom);

    @SqlQuery("select * from jeu where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Jeu findById(@Bind("id") int id);
    
    @SqlQuery("select * from jeu")
	@RegisterMapperFactory(BeanMapperFactory.class)
List<Jeu> getAll();

    @SqlUpdate("drop table if exists jeu")
    void dropJeuTable();

    void close();
}