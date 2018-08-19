package com.fme.dao.impl;

import com.fme.bean.Film;
import com.fme.constant.GenreEnum;
import com.fme.dao.AbstractDao;
import com.fme.dao.FilmDao;
import com.fme.dao.rowmapper.FilmRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@Repository
public class FilmDaoImpl extends AbstractDao<FilmRowMapper,Film> implements FilmDao {

    private static final String INSERT_FILM="insert into film values (SEQ_FILM.nextval,?,?,?,?,?,?)";
    private static final String SELECT_BY_ID="select id,filmName,duration,releaseYear,plot,imgPath,localPath from film where id=?";
    private static final String SELECT_BY_REALISATOR="select f.id,f.filmName,f.duration,f.releaseYear,f.plot,f.imgPath,f.localPath from film f inner join real2film r2f on (f.id=r2f.idFilm) inner join realisator r on (r.id=r2f.idreal) where r.lastName=?";
    private static final String SELECT_BY_FILM_NAME="select id,filmName,duration,releaseYear,plot,imgPath,localPath from film where filmName=?";
    private static final String SELECT_BY_FILM_RELEASE="select id,filmName,duration,releaseYear,plot,imgPath,localPath from film where releaseYear=?";
    private static final String SELECT_BY_GENRE="select f.id,f.filmName,f.duration,f.releaseYear,f.plot,f.imgPath,f.localPath from film f inner join genre2film g2f on (f.id=g2f.idFilm) inner join genre g on (g2f.idGenre=g.id) where g.name=?";

    @Override
    public List<Film> findAll() {
        return null;
    }

    @Override
    public PreparedStatementCreator buildInsertPreparedStatementCreator(Film object) {
        Assert.notNull(object,"Film identifiant ne peut pas être null");
        return (connection) -> {
            final PreparedStatement ps = connection.prepareStatement(INSERT_FILM, new String[]{"id"});
            ps.setString(1, object.getFilmName());
            ps.setString(2,object.getDuration());
            ps.setDate(3, Date.valueOf(object.getReleaseYear()));
            ps.setString(4,object.getPlot());
            ps.setString(5,object.getImgPath());
            ps.setString(6,object.getLocalPath());
            return ps;
        };
    }

    @Override
    public String defineSelectByIdQuery() {
        return SELECT_BY_ID;
    }

    @Override
    public void updateObject(Film object) {

    }

    @Override
    public List<Film> findFilmsByRealisator(String realisatorName) {
        Assert.notNull(realisatorName,"RealisatorName ne peut pas être null");
        return this.jdbcTemplate.query(SELECT_BY_REALISATOR,new Object[]{realisatorName},this.rowMapper);
    }

    @Override
    public Film findFilmByName(String filmName) {
        Assert.notNull(filmName,"filmName ne peut pas être null");
        return this.jdbcTemplate.queryForObject(SELECT_BY_FILM_NAME,new Object[]{filmName},this.rowMapper);
    }

    @Override
    public List<Film> findFilmsByReleaseYear(LocalDate releaseYear) {
        Assert.notNull(releaseYear,"releaseYear ne peut pas être null");
        return this.jdbcTemplate.query(SELECT_BY_FILM_RELEASE,new Object[]{Date.valueOf(releaseYear)},this.rowMapper);
    }

    @Override
    public List<Film> findFilmByGenre(GenreEnum genre) {
        Assert.notNull(genre,"genre ne peut pas être null");
        return this.jdbcTemplate.query(SELECT_BY_GENRE,new Object[]{genre.getValue()},this.rowMapper);
    }
}
