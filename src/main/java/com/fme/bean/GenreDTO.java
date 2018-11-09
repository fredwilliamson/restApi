package com.fme.bean;

import com.fme.constant.GenreEnum;

public class GenreDTO extends PrimaryKey{
    private GenreEnum name;

    public GenreDTO(GenreEnum name) {
        this.name = name;
    }

    public GenreDTO() {
    }

    public GenreEnum getName() {
        return name;
    }

    public void setName(GenreEnum name) {
        this.name = name;
    }
}
