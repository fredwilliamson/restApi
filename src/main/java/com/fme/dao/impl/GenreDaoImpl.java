package com.fme.dao.impl;

import com.fme.bean.Genre;
import com.fme.dao.AbstractDao;
import com.fme.dao.rowmapper.GenreRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.util.List;

public class GenreDaoImpl extends AbstractDao<GenreRowMapper,Genre> {
    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public PreparedStatementCreator buildInsertPreparedStatementCreator(Genre object) {
        return null;
    }

    @Override
    public String defineSelectByIdQuery() {
        return null;
    }

    @Override
    public void updateObject(Genre object) {

    }
}
