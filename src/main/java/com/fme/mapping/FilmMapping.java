package com.fme.mapping;

import com.fme.bean.FilmDTO;
import com.fme.dbo.Film;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public final class FilmMapping {

    private FilmMapping(){}

    public static FilmDTO convertEntityToDto(final Film filmEntity){
        Assert.notNull(filmEntity,"l'entité film ne peut pas être null");

        final FilmDTO filmDTO = new FilmDTO();

        filmDTO.setDuration(filmEntity.getDuration());
        filmDTO.setFilmName(filmEntity.getFilmName());
        filmDTO.setImgPath(filmEntity.getImgPath());
        filmDTO.setLocalPath(filmEntity.getLocalPath());
        filmDTO.setReleaseYear(filmEntity.getReleaseYear());
        filmDTO.setId(filmEntity.getId());

        return filmDTO;
    }

    public static List<FilmDTO> convertEntitiesToDtos(final List<Film> filmEntities){
        Assert.notEmpty(filmEntities,"les entites film ne peuvent pas être vides");

        return filmEntities.stream().map(FilmMapping::convertEntityToDto).collect(Collectors.toList());
    }
}
