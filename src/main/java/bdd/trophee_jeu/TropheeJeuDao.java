package bdd.trophee_jeu;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface TropheeJeuDao {

    @SqlUpdate("create table trophee_jeu ("
    		+ "idJeu integer foreign key references Jeu(id), "
    		+ "idTrophee integer foreign key references Trophee(id),"
    		+ "constraint pk_possedeID primary key (idJeu, idTrophee)")
    void createTropheeJeuTable();

    @SqlUpdate("insert into trophee_jeu (idJeu, idTrophee) "
            + "values (:idJeu, :idTrophee)")
    @GetGeneratedKeys
    int insert(@Bind("idJeu") int idJeu, @Bind("idTrophee") int idTrophee);

    @SqlQuery("select * from trophee_jeu where idJeu = :idJeu")
    @RegisterMapperFactory(BeanMapperFactory.class)
    TropheeJeu findById(@Bind("idJeu") int idJeu);

    @SqlUpdate("drop table if exists trophee_jeu")
    void dropTropheeJeuTable();

    void close();
}