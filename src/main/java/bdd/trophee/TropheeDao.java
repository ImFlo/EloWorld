package bdd.trophee;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface TropheeDao {

    @SqlUpdate("create table trophee (id integer primary key autoincrement, nom text not null, description text)")
    void createTropheeTable();

    @SqlUpdate("insert into trophee (nom, description) "
            + "values (:nom, :description)")
    @GetGeneratedKeys
    int insert(@Bind("nom") String nom, @Bind("description") String description);

    @SqlQuery("select * from trophee where id = :id")
    @RegisterMapperFactory(BeanMapperFactory.class)
    Trophee findById(@Bind("id") int id);

    @SqlUpdate("drop table if exists trophee")
    void dropTropheeTable();

    void close();
}