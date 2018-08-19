package com.fme.bean;

import com.fme.constant.GenreEnum;

public class Genre extends PrimaryKey{
    private GenreEnum name;

    public Genre(GenreEnum name) {
        this.name = name;
    }

    public Genre() {
    }

    public GenreEnum getName() {
        return name;
    }

    public void setName(GenreEnum name) {
        this.name = name;
    }
}
