package bdd.possede.trophee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface PossedeTropheeDao {

    @SqlUpdate("create table possede_trophee "
    		+ "(idJoueur integer,"
    		+ "idTrophee integer,"
    		+ "foreign key (idJoueur) references Joueur(id),"
    		+ "foreign key (idTrophee) references Trophee(id),"
    		+ "constraint pk_possedeId primary key (idJoueur, idTrophee))")
    void createPossedeTropheeTable();

    @SqlUpdate("insert into possede_trophee (idJoueur, idTrophee) "
            + "values (:idJoueur, :idTrophee)")
    @GetGeneratedKeys
    int insert(@Bind("idJoueur") int idJoueur, @Bind("idTrophee") int idTrophee);

    @SqlQuery("select * from possede_trophee where idJoueur = :idJoueur")
    @RegisterMapperFactory(BeanMapperFactory.class)
    PossedeTrophee findById(@Bind("idJoueur") int idJoueur);

    @SqlUpdate("drop table if exists possede_trophee")
    void dropJeuTable();

    void close();
}