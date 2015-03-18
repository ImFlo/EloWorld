package bdd.publie;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface PublieDao {

    @SqlUpdate("create table publie ("
    		+ "idJoueur integer foreign key references Joueur(id), "
    		+ "idPublication integer foreign key references Publication(id),"
    		+ "constraint pk_possedeID primary key (idJoueur, idPublication)")
    void createPublieTable();

    @SqlUpdate("insert into publie (idJoueur, idPublication) "
            + "values (:idJoueur, :idPublication)")
    @GetGeneratedKeys
    int insert(@Bind("idJoueur") int idJoueur, @Bind("idPublication") int idPublication);

    @SqlQuery("select * from publie where idJoueur = :idJoueur")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Publie findById(@Bind("idJoueur") int idJoueur);

    @SqlUpdate("drop table if exists publie")
    void dropPublieTable();

    void close();
}