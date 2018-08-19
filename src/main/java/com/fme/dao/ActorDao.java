package com.fme.dao;

import com.fme.bean.Actor;
import com.fme.constant.GenreEnum;

import java.util.List;

public interface ActorDao {
    List<Actor> findActorByName(String lastName);

    List<Actor> findActorsByFilm(String filmName);

    List<Actor> findActorsByGenre(GenreEnum genre);

}
