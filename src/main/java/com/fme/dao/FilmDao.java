package com.fme.dao;

import com.fme.bean.Film;
import com.fme.constant.GenreEnum;

import java.time.LocalDate;
import java.util.List;

public interface FilmDao {
    List<Film> findFilmsByRealisator(String realisatorName);

    Film findFilmByName(String filmName);

    List<Film> findFilmsByReleaseYear(LocalDate releaseYear);

    List<Film> findFilmByGenre(GenreEnum genre);
}
