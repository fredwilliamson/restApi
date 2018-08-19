package com.fme.dao.rowmapper;

import com.fme.bean.Film;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FilmRowMapper extends AbstractRowMapper<Film> {
    @Override
    public Film mapRow(ResultSet resultSet, int i) throws SQLException {
        final Film film =super.mapRow(resultSet, i);
        film.setReleaseYear(resultSet.getDate("releaseYear").toLocalDate());
        film.setFilmName(resultSet.getString("filmName"));
        film.setDuration(resultSet.getString("duration"));
        film.setFilmName(resultSet.getString("plot"));
        film.setDuration(resultSet.getString("imgPath"));
        film.setFilmName(resultSet.getString("localPath"));
        return super.mapRow(resultSet, i);
    }

    @Override
    public Film instantiateParam() {
        return new Film();
    }
}
