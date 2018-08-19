package com.fme.dao.rowmapper;

import com.fme.bean.Actor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ActorRowMapper extends AbstractPersonMapper<Actor>{


    @Override
    public Actor instantiateParam(){
        return new Actor();
    }

    @Override
    public Actor mapRow(ResultSet resultSet, int i) throws SQLException {
        return super.mapRow(resultSet, i);
    }
}
