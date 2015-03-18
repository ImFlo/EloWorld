package bdd.genre.jeu;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

import bdd.possede.jeu.PossedeJeu;

public interface GenreJeuDao {

	@SqlUpdate("create table genre_jeu ("
    		+ "idJeu integer foreign key references Jeu(id), "
    		+ "idCategorie integer foreign key references Categorie(id),"
    		+ "constraint pk_possedeID primary key (idJeu, idCategorie)")
	void createGenreJeuTable();

	@SqlUpdate("insert into genre_jeu (idJeu, idCategorie) "
            + "values (:idJeu, :idCategorie)")
    @GetGeneratedKeys
    int insert(@Bind("idJeu") int idJeu, @Bind("idCategorie") int idCategorie);
	
	@SqlQuery("select * from genre_jeu where idJeu = :idJeu")
    @RegisterMapperFactory(BeanMapperFactory.class)
    GenreJeu findById(@Bind("idJeu") int idJeu);
	
	@SqlUpdate("drop table if exists genre_jeu")
    void dropGenreJeuTable();

    void close();
	
}
