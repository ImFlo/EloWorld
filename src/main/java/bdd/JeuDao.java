package bdd;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface JeuDao {
	@SqlUpdate("create table jeu (id integer primary key autoincrement, appID text not null, nom text not null)")
	void createJeuTable();

	@SqlUpdate("insert into jeu (appID, nom) " +
			"values (:appID, :nom)")
	@GetGeneratedKeys
	int insert(@Bind("appID") String appID, @Bind("nom") String nom);

	@SqlQuery("select * from jeu where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
	Joueur findById(@Bind("id") int id);

	@SqlUpdate("drop table if exists jeu")
	void dropJeuTable(); 
	
	void close();
}