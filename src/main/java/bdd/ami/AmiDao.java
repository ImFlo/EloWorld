package bdd.ami;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.List;
import bdd.joueur.*;

public interface AmiDao {

    @SqlUpdate("create table ami ("
    		+ "idJoueur1 integer,"
    		+ "idJoueur2 integer,"
    		+ "foreign key (idJoueur1) references Joueur(id),"
    		+ "foreign key (idJoueur2) references Joueur(id),"
    		+ "constraint pk_possedeID primary key (idJoueur1, idJoueur2))")
    void createAmiTable();

    @SqlUpdate("insert into ami (idJoueur1, idJoueur2) "
            + "values (:idJoueur1, :idJoueur2)")
    @GetGeneratedKeys
    int insert(@Bind("idJoueur1") int idJoueur1, @Bind("idJoueur2") int idJoueur2);

    @SqlQuery("select * from ami where idJoueur1 = :idJoueur1")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Ami findById(@Bind("idJoueur1") int idJoueur1);

    @SqlQuery("select count(*) from ami where (idJoueur1 = :idJ1 and idJoueur2 = :idJ2) or (idJoueur2 = :idJ1 and idJoueur1 = :idJ2) ")
    int areFriend(@Bind("idJ1") int idJ1, @Bind("idJ2") int idJ2);

		@SqlQuery("select *  from joueur where id in (select idJoueur2 from ami where idJoueur1 = :id) or id in (select idJoueur1 from ami where idJoueur2 = :id)")
		@RegisterMapperFactory(BeanMapperFactory.class)
		List<Joueur> getFriendList(@Bind("id") int id);

    @SqlUpdate("drop table if exists ami")
    void dropAmiTable();

    void close();
}
