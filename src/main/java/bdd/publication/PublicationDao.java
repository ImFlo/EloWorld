package bdd.publication;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import bdd.joueur.Joueur;

import java.sql.Date;
import java.util.List;

public interface PublicationDao {

    @SqlUpdate("create table publication (id integer primary key autoincrement, texte text not null, date text not null)")
    void createPublicationTable();

    @SqlUpdate("insert into publication (texte, date) "
            + "values (:texte, :date)")
    @GetGeneratedKeys
    int insert(@Bind("texte") String texte, @Bind("date") String date);

		@SqlUpdate("insert into publie values(:idJ, :idG, :idP)")
		int publie(@Bind("idJ") int idJ, @Bind("idG") int idG, @Bind("idP") int idP);

    @SqlQuery("select * from publication where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Publication findById(@Bind("id") int id);
   
    @SqlUpdate("drop table if exists publication")
    void dropPublicationTable();
		

		//pour l'accueil
		@SqlQuery("SELECT * FROM publication WHERE id IN (SELECT idPublication FROM publie WHERE idJoueur = :id OR idJoueur in (SELECT idJoueur2 FROM ami WHERE idJoueur1 = :id)) ORDER BY date DESC")
		@RegisterMapperFactory(BeanMapperFactory.class)
		List<Publication> getPubFor(@Bind("id") int id);

		//pour le profil
		@SqlQuery("select * from publication where id in (select idPublication from publie where idJoueur = :id)")
		@RegisterMapperFactory(BeanMapperFactory.class)
		List<Publication> getPubOf(@Bind("id") int id);

    void close();
}
