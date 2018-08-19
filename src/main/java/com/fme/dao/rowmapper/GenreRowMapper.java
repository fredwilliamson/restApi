package com.fme.dao.rowmapper;

import com.fme.bean.Genre;

public class GenreRowMapper extends AbstractRowMapper<Genre> {
    @Override
    public Genre instantiateParam() {
        return new Genre();
    }
}
