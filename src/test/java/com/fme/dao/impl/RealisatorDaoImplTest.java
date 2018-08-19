package com.fme.dao.impl;

import com.fme.AbstractDaoImplTest;
import com.fme.bean.Realisator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class RealisatorDaoImplTest extends AbstractDaoImplTest {

    @Autowired
    private RealisatorDaoImpl dao;

    @Test
    public void findAll() {
    }

    @Test
    public void findUniqueById() {
    }

    @Test
    public void insertOkTest() {
        final Realisator real=new Realisator();
        real.setFirstName("stan");
        real.setLastName(REALISATOR_NAME);
        assertNotNull(this.dao.insertObject(real));
    }

    @Test
    public void defineSelectByIdQuery() {
    }

    @Test
    public void updateObject() {
    }

    @Test
    public void findRealisatorsByFilmName() {
        assertNotNull(this.dao.findRealisatorsByFilmName(FILM_NAME));
    }

    @Test
    public void findRealisatorsByName() {
        List<Realisator> results=this.dao.findRealisatorsByName(REALISATOR_NAME);
        assertNotNull(results);
        assertTrue(CollectionUtils.isNotEmpty(results));
    }
}