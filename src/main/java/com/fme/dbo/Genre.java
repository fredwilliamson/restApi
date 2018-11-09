package com.fme.dbo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre extends LongPrimaryKey{

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "genres",cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
