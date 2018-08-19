package com.fme.dao.impl;

import com.fme.AbstractDaoImplTest;
import com.fme.bean.Film;
import com.fme.dao.FilmDao;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class FilmDaoImplTest extends AbstractDaoImplTest {

    @Autowired
    private FilmDaoImpl dao;

    @Test
    public void findUniqueById() {
        assertNotNull(this.dao.findUniqueById(this.idFilm));
    }

    @Test
    public void insetFilmTestOK() {
        final Film film =new Film();
        film.setFilmName("kick ass");
        film.setDuration("2h30");
        film.setImgPath("/fmess/tmp/img.jpeg");
        film.setPlot("it's a plot");
        film.setLocalPath("/fmess/tmp/");
        film.setReleaseYear(RELEASE_YEAR);
        assertNotNull(this.dao.insertObject(film));
    }

    @Test
    public void findFilmByNameTestOk() {
        assertNotNull(this.dao.findFilmByName(FILM_NAME));
    }

    @Test
    public void findFilmsByRealisator() {
        final List<Film> results =this.dao.findFilmsByRealisator(REALISATOR_NAME);
        assertNotNull(results);
        assertTrue(CollectionUtils.isNotEmpty(results));
    }

    @Test
    public void findFilmsByReleaseYearTestOk(){
        final List<Film> results =this.dao.findFilmsByReleaseYear(RELEASE_YEAR);
        assertNotNull(results);
        assertTrue(CollectionUtils.isNotEmpty(results));
    }

    @Test
    public void findFilmsByGenreTestOk(){
        final List<Film> results =this.dao.findFilmByGenre(GENRE);
        assertNotNull(results);
        assertTrue(CollectionUtils.isNotEmpty(results));
    }

}