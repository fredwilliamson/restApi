package com.fme.dao;

import com.fme.bean.Film;
import com.fme.dao.rowmapper.AbstractRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

@Repository
public abstract class AbstractDao<R extends AbstractRowMapper,T> {


    @Autowired
    protected R rowMapper;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public abstract List<T> findAll();

    public T findUniqueById(Long id) {
        Assert.notNull(id,"identifiant ne peut pas être null");
        return (T) this.jdbcTemplate.queryForObject(defineSelectByIdQuery(),new Object[]{id},this.rowMapper);
    }

    public Long insertObject(T object) {
        final KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(buildInsertPreparedStatementCreator(object),keyHolder);
        return keyHolder.getKey().longValue();
    }

    public abstract PreparedStatementCreator buildInsertPreparedStatementCreator(T object);

    public abstract String defineSelectByIdQuery();

    public abstract void updateObject(T object);


}
