package com.fme.service;

import com.fme.bean.FilmDTO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FilmService {

    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    List<FilmDTO> findFilmsByFilmName(final String filmName);

}
