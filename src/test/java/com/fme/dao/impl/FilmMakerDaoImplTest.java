package com.fme.dao.impl;

import com.fme.AbstractDaoImplTest;
import com.fme.dbo.Film;
import com.fme.dbo.FilmMaker;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FilmMakerDaoImplTest extends AbstractDaoImplTest {

    @Autowired
    private FilmMakerDaoImpl dao;

    @Test
    public void findAll() {
    }

    @Test
    public void findUniqueById() {
    }

    @Test
    public void insertOkTest() {
        final Film film =new Film();
        film.setFilmName("kick ass");
        film.setDuration("2h30");
        film.setImgPath("/fmess/tmp/img.jpeg");
        film.setPlot("it's a plot");
        film.setLocalPath("/fmess/tmp/");
        film.setReleaseYear(RELEASE_YEAR);
        final FilmMaker real=new FilmMaker();
        real.setFirstName("stan");
        real.setLastName(REALISATOR_NAME);
        real.setFilms(new ArrayList<>());
        real.getFilms().add(film);
        this.dao.insert(real);
        assertNotNull(film.getId());
    }

    @Test
    public void defineSelectByIdQuery() {
    }

    @Test
    public void updateObject() {
    }

    @Test
    public void findRealisatorsByFilmName() {
        assertNotNull(this.dao.findFilmMakerByFilmName(FILM_NAME));
    }

    @Test
    public void findRealisatorsByName() {
        List<FilmMaker> results=this.dao.findFilmMakerByName(REALISATOR_NAME);
        assertNotNull(results);
        assertTrue(CollectionUtils.isNotEmpty(results));
    }
}