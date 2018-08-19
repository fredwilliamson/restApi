package com.fme.dao.rowmapper;

import com.fme.bean.Realisator;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RealisatorRowMapper extends AbstractPersonMapper<Realisator> {
    @Override
    public Realisator instantiateParam() {
        return new Realisator();
    }

    @Override
    public Realisator mapRow(ResultSet resultSet, int i) throws SQLException {
        return super.mapRow(resultSet, i);
    }
}
