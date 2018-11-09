package com.fme.dbo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "film")
public class Film extends LongPrimaryKey {

    @Column(name="film_name")
    private String filmName;

    @Column(name="duration")
    private String duration;

    @Column(name="release_year")
    private LocalDate releaseYear;

    @Column(name="plot")
    private String plot;

    @Column(name="img_path")
    private String imgPath;

    @Column(name="local_path")
    private String localPath;

    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "actor2film", joinColumns = {
            @JoinColumn(name = "idfilm", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "idactor",
                    nullable = false, updatable = false) })
    private List<Actor> actors;

    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "real2film", joinColumns = {
            @JoinColumn(name = "idfilm", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "idreal",
                    nullable = false, updatable = false) })
    private List<FilmMaker> filmMakers;

    @ManyToMany(fetch = FetchType.LAZY, cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "genre2film", joinColumns = {
            @JoinColumn(name = "idfilm", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "idGenre",
                    nullable = false, updatable = false) })
    private List<Genre> genres;


    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<FilmMaker> getFilmMakers() {
        return filmMakers;
    }

    public void setFilmMakers(List<FilmMaker> filmMakers) {
        this.filmMakers = filmMakers;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }
}
