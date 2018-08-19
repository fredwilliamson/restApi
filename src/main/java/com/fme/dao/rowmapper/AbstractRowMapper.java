package com.fme.dao.rowmapper;

import com.fme.bean.PrimaryKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractRowMapper<T extends PrimaryKey> implements RowMapper<T> {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    protected T objectToFill;

    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        objectToFill= instantiateParam();
        objectToFill.setId(resultSet.getLong("id"));
        return objectToFill;
    }

    public abstract T instantiateParam();

}
