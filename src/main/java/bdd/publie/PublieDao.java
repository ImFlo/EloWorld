package bdd.publie;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface PublieDao {

    @SqlUpdate("create table publie ("
    		+ "idJoueur integer,"
    		+ "idJeu integer,"
    		+ "idPublication integer,"
    		+ "foreign key (idJoueur) references Joueur(id),"
    		+ "foreign key (idJeu) references Jeu(id),"
    		+ "foreign key (idPublication) references Publication(id),"
    		+ "constraint pk_possedeID primary key (idJoueur, idJeu, idPublication))")
    void createPublieTable();

    @SqlUpdate("insert into publie (idJoueur, idJeu, idPublication) "
            + "values (:idJoueur, :idJeu, :idPublication)")
    @GetGeneratedKeys
    int insert(@Bind("idJoueur") int idJoueur, @Bind("idJeu") int idJeu, @Bind("idPublication") int idPublication);

    @SqlQuery("select * from publie where idJoueur = :idJoueur")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Publie findById(@Bind("idJoueur") int idJoueur);

    @SqlUpdate("drop table if exists publie")
    void dropPublieTable();

    void close();
}