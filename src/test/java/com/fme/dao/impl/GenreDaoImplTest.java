package com.fme.dao.impl;

import com.fme.AbstractDaoImplTest;
import com.fme.dbo.Genre;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GenreDaoImplTest extends AbstractDaoImplTest {

    @Autowired
    private GenreDaoImpl dao;

    @Test
    public void insetGenreOK() {
        final Genre film =new Genre();
        film.setName("war");
        this.dao.insert(film);
    }

}