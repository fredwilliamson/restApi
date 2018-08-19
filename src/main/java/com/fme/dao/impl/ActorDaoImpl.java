package com.fme.dao.impl;

import com.fme.bean.Actor;
import com.fme.constant.GenreEnum;
import com.fme.dao.AbstractDao;
import com.fme.dao.ActorDao;
import com.fme.dao.rowmapper.ActorRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ActorDaoImpl extends AbstractDao<ActorRowMapper,Actor> implements ActorDao {

    private static final String FIND_ACTOR_BY_ID ="SELECT id,lastName,name from actor where id=?";
    private static final String FIND_ACTOR_BY_NAME="SELECT id,lastName,name from actor where lastName=?";
    private static final String INSERT_ACTOR="insert into actor values(seq_actor.nextval,?,?)";
    private static final String ACTORS_BY_FILM="select a.id,a.lastName,a.name from actor a inner join actor2film a2f on (a.id=a2f.idActor) inner join film f on (f.id=a2f.idfilm) where filmName=?";

    @Override
    public List<Actor> findAll() {
        return null;
    }

    @Override
    public PreparedStatementCreator buildInsertPreparedStatementCreator(final Actor actor) {
        Assert.notNull(actor,"Acteur ne peut pas être null");
        return (connection)-> {
            final PreparedStatement ps = connection.prepareStatement(INSERT_ACTOR, new String[]{"id"});
            ps.setString(1, actor.getFirstName());
            ps.setString(2, actor.getLastName());
            return ps;
        };
    }

    @Override
    public String defineSelectByIdQuery() {
        return FIND_ACTOR_BY_ID;
    }

    @Override
    public void updateObject(Actor object) {

    }

    @Override
    public List<Actor> findActorByName(String lastName) {
        Assert.notNull(lastName,"nom de famille acteur ne peut pas être null");
        final Object[] args ={lastName};
        return this.jdbcTemplate.query(FIND_ACTOR_BY_NAME,args,this.rowMapper);
    }

    @Override
    public List<Actor> findActorsByFilm(String filmName) {
        Assert.notNull(filmName,"nom du film ne peut pas être null");
        final Object[] args ={filmName};
        return this.jdbcTemplate.query(ACTORS_BY_FILM,args,this.rowMapper);
    }

    @Override
    public List<Actor> findActorsByGenre(GenreEnum genre) {
        return null;
    }
}
