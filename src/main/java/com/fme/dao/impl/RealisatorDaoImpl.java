package com.fme.dao.impl;

import com.fme.bean.Realisator;
import com.fme.constant.GenreEnum;
import com.fme.dao.AbstractDao;
import com.fme.dao.RealisatorDao;
import com.fme.dao.rowmapper.RealisatorRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class RealisatorDaoImpl extends AbstractDao<RealisatorRowMapper,Realisator> implements RealisatorDao {

    private static final String INSERT_REALISATOR="insert into realisator values (SEQ_REAL.nextval,?,?)";
    private static final String SELECT_BY_ID="select id,firstName,lastName from realisator where id=?";
    private static final String SELECT_BY_FILM="select r.id,r.lastName,r.firstName from film f inner join real2film r2f on (f.id=r2f.idFilm) inner join realisator r on (r.id=r2f.idreal) where f.filmName=?";
    private static final String SELECT_BY_REAL_NAME="select r.id,r.lastName,r.firstName from realisator r where r.lastName=?";

    @Override
    public List<Realisator> findAll() {
        return null;
    }

    @Override
    public PreparedStatementCreator buildInsertPreparedStatementCreator(Realisator object) {
        Assert.notNull(object,"Realisator identifiant ne peut pas être null");
        return (connection) -> {
            final PreparedStatement ps = connection.prepareStatement(INSERT_REALISATOR, new String[]{"id"});
            ps.setString(1, object.getFirstName());
            ps.setString(2,object.getLastName());
            return ps;
        };
    }

    @Override
    public String defineSelectByIdQuery() {
        return SELECT_BY_ID;
    }

    @Override
    public void updateObject(Realisator object) {

    }

    @Override
    public List<Realisator> findRealisatorsByFilmName(String filmName) {
        Assert.notNull(filmName,"filmName ne peut pas être null");
        return this.jdbcTemplate.query(SELECT_BY_FILM,new Object[]{filmName},this.rowMapper);
    }

    @Override
    public List<Realisator> findRealisatorsByName(String realName) {
        Assert.notNull(realName,"realName ne peut pas être null");
        return this.jdbcTemplate.query(SELECT_BY_REAL_NAME,new Object[]{realName},this.rowMapper);
    }

    @Override
    public List<Realisator> findRealisatorByGenre(GenreEnum genre) {
        return null;
    }
}