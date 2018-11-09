package com.fme.controller;

import com.fme.bean.FilmDTO;
import com.fme.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("film")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/filmNames")
    public List<FilmDTO> getFilmsByFilmName(@RequestParam(value = "filmName") final String filmName){
        return filmService.findFilmsByFilmName(filmName);
    }
}
