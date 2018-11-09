package com.fme.dao;

import com.fme.dbo.Film;

import java.time.LocalDate;
import java.util.List;

public interface FilmDao {
    List<Film> findFilmsByRealisator(String realisatorName);

    List<Film> findFilmByName(String filmName);

    List<Film> findFilmsByReleaseYear(LocalDate releaseYear);

    List<Film> findFilmByGenre(String genre);
}
