package com.fme.dao.impl;

import com.fme.constant.GenreEnum;
import com.fme.dao.AbstractDao;
import com.fme.dao.ActorDao;
import com.fme.dbo.Actor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ActorDaoImpl extends AbstractDao<Actor> implements ActorDao {

    private static final String ACTORS_BY_FILM="SELECT actor FROM Actor actor inner join actor.films films where films.filmName=:propFilmName";


    @Override
    public List<Actor> findActorByName(String lastName) {
        Assert.notNull(lastName,"nom de famille acteur ne peut pas être null");
        final CriteriaBuilder builder= this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Actor> query =builder.createQuery(Actor.class);
        final Root<Actor> root = query.from(Actor.class);
        query.where(builder.equal(root.get("lastName"),lastName));

        return this.entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Actor> findActorsByFilm(String filmName) {
        Assert.notNull(filmName,"nom du film ne peut pas être null");
        return this.entityManager.createQuery(ACTORS_BY_FILM).setParameter("propFilmName",filmName).getResultList();
    }

    @Override
    public List<Actor> findActorsByGenre(GenreEnum genre) {
        return (List<Actor>) CollectionUtils.EMPTY_COLLECTION;
    }
}
