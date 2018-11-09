package com.fme.dao.impl;

import com.fme.AbstractDaoImplTest;
import com.fme.dbo.Actor;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ActorDaoImplTest extends AbstractDaoImplTest {

    @Autowired
    private ActorDaoImpl dao;

    @Test
    public void findByNameTest() {
        assertNotNull(dao.findActorByName(ACTOR_NAME));
    }

    @Test
    public void insertTestOK(){
        final Actor actor = new Actor();
        actor.setFirstName("Delon");
        actor.setLastName("Alain");
        dao.insert(actor);
    }

    @Test
    public void selectActorByFilmOK(){
        List<Actor> actors = dao.findActorsByFilm(FILM_NAME);
        assertNotNull(actors);
        assertTrue(CollectionUtils.isNotEmpty(actors));
    }

}