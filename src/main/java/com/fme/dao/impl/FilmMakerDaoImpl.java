package com.fme.dao.impl;

import com.fme.constant.GenreEnum;
import com.fme.dao.AbstractDao;
import com.fme.dao.FilmMakerDao;
import com.fme.dbo.FilmMaker;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

@Repository
public class FilmMakerDaoImpl extends AbstractDao<FilmMaker> implements FilmMakerDao {

    private static final String SELECT_BY_FILM="SELECT filmMaker FROM FilmMaker filmMaker inner join filmMaker.films films WHERE films.filmName = :propFilmName";
    private static final String SELECT_BY_REAL_NAME="FROM FilmMaker filmMaker WHERE filmMaker.lastName = :propLastName";


    @Override
    public List<FilmMaker> findFilmMakerByFilmName(String filmName) {
        Assert.notNull(filmName,"filmName ne peut pas être null");
        return this.entityManager.createQuery(SELECT_BY_FILM).setParameter("propFilmName",filmName).getResultList();
    }

    @Override
    public List<FilmMaker> findFilmMakerByName(String realName) {
        Assert.notNull(realName,"realName ne peut pas être null");
        return this.entityManager.createQuery(SELECT_BY_REAL_NAME).setParameter("propLastName",realName).getResultList();
    }

    @Override
    public List<FilmMaker> findFilmMakerByGenre(GenreEnum genre) {
        return Collections.emptyList();
    }
}