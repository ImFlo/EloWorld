package bdd.possede.jeu;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import java.util.*;

public interface PossedeJeuDao {

    @SqlUpdate("create table possede_jeu ("
    		+ "idJoueur integer, "
    		+ "idJeu integer,"
    		+ "foreign key (idJoueur) references Joueur(id),"
    		+ "foreign key (idJeu) references Jeu(id),"
    		+ "constraint pk_possedeID primary key (idJoueur, idJeu))")
    void createPossedeJeuTable();

    @SqlUpdate("insert into possede_jeu (idJoueur, idJeu) "
            + "values (:idJoueur, :idJeu)")
    @GetGeneratedKeys
    int insert(@Bind("idJoueur") int idJoueur, @Bind("idJeu") int idJeu);

    @SqlQuery("select * from possede_jeu where idJoueur = :idJoueur")
    @RegisterMapperFactory(BeanMapperFactory.class)
    PossedeJeu findById(@Bind("idJoueur") int idJoueur);

    @SqlUpdate("drop table if exists possede_jeu")
    void dropPossedeJeuTable();
		
		@SqlQuery("select nom from jeu where id in (select idJeu from possede_jeu where idJoueur = :id)")
		List<String> getJeuDe(@Bind("id") int id);

    void close();
}
