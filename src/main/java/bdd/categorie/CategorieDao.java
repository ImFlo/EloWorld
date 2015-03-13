package bdd.categorie;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface CategorieDao {

    @SqlUpdate("create table categorie (id integer primary key autoincrement, nom text not null)")
    void createCategorieTable();

    @SqlUpdate("insert into categorie (nom) "
            + "values (:nom)")
    @GetGeneratedKeys
    int insert(@Bind("nom") String nom);

    @SqlQuery("select * from categorie where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Categorie findById(@Bind("id") int id);

    @SqlUpdate("drop table if exists categorie")
    void dropCategorieTable();

    void close();
}