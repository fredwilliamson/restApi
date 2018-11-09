package com.fme.service.impl;

import com.fme.bean.FilmDTO;
import com.fme.dao.FilmDao;
import com.fme.dbo.Film;
import com.fme.mapping.FilmMapping;
import com.fme.service.FilmService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmDao filmDao;

    @Override
    public List<FilmDTO> findFilmsByFilmName(String filmName) {
        final List<Film> filmsFound = filmDao.findFilmByName(filmName);
        if(CollectionUtils.isNotEmpty(filmsFound)){
            return FilmMapping.convertEntitiesToDtos(filmsFound);
        }
        return new ArrayList<>();
    }
}
