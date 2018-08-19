package com.fme.dao;

import com.fme.bean.Realisator;
import com.fme.constant.GenreEnum;

import java.util.List;

public interface RealisatorDao {

    List<Realisator> findRealisatorsByFilmName(String filmName);

    List<Realisator> findRealisatorsByName(String realName);

    List<Realisator> findRealisatorByGenre(GenreEnum genre);
}
