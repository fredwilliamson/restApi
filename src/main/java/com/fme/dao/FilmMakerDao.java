package com.fme.dao;

import com.fme.constant.GenreEnum;
import com.fme.dbo.FilmMaker;

import java.util.List;

public interface FilmMakerDao {

    List<FilmMaker> findFilmMakerByFilmName(String filmName);

    List<FilmMaker> findFilmMakerByName(String realName);

    List<FilmMaker> findFilmMakerByGenre(GenreEnum genre);
}
