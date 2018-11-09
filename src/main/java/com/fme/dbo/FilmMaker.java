package com.fme.dbo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "realisator")
public class FilmMaker extends Person {

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "filmMakers",cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
