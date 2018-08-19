package com.fme.dao.rowmapper;

import com.fme.bean.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractPersonMapper<T extends Person> extends AbstractRowMapper<T> {
    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        log.info("rowmapper person");
        final T person =super.mapRow(resultSet, i);
        person.setFirstName(resultSet.getString("firstName"));
        person.setFirstName(resultSet.getString("lastName"));
        return person;
    }
}
