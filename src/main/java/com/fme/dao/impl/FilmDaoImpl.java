package com.fme.dao.impl;

import com.fme.dao.AbstractDao;
import com.fme.dao.FilmDao;
import com.fme.dbo.Film;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Repository
public class FilmDaoImpl extends AbstractDao<Film> implements FilmDao {

    private static final String SELECT_BY_REALISATOR="SELECT film FROM Film as film inner join film.filmMakers filmMakers WHERE filmMakers.lastName =:propLastName";
    private static final String SELECT_BY_FILM_NAME="FROM Film film WHERE film.filmName like :propFilmName";
    private static final String SELECT_BY_FILM_RELEASE="FROM Film film WHERE film.releaseYear =:propReleaseYear";
    private static final String SELECT_BY_GENRE="SELECT f FROM Film f inner join f.genres genres  where genres.name =:propGenre";



    @Override
    public List<Film> findFilmsByRealisator(String realisatorName) {
        Assert.notNull(realisatorName,"RealisatorName ne peut pas être null");
        return this.entityManager.createQuery(SELECT_BY_REALISATOR).setParameter("propLastName",realisatorName).getResultList();
    }

    @Override
    public List<Film> findFilmByName(String filmName) {
        Assert.notNull(filmName,"filmName ne peut pas être null");
        return this.entityManager.createQuery(SELECT_BY_FILM_NAME).setParameter("propFilmName",filmName).getResultList();
    }

    @Override
    public List<Film> findFilmsByReleaseYear(LocalDate releaseYear) {
        Assert.notNull(releaseYear,"releaseYear ne peut pas être null");
        return this.entityManager.createQuery(SELECT_BY_FILM_RELEASE).setParameter("propReleaseYear",releaseYear).getResultList();
    }

    @Override
    public List<Film> findFilmByGenre(String genre) {
        Assert.notNull(genre,"genre ne peut pas être null");
        return this.entityManager.createQuery(SELECT_BY_GENRE).setParameter("propGenre",genre).getResultList();
    }
}
