package com.fme.constant;

public enum GenreEnum {
    Comedy("Comédie"),
    Romantic("Romantique"),
    Drama("Drame"),
    Fantastic("Fantastique"),
    SF("Science-Fiction"),
    Peplum("Péplum"),
    Aventure("Aventure"),
    Action("Action"),
    Western("Western"),
    Fantasy("Fantasie"),
    Horror("Horreur"),
    Thriller("Thriller"),
    Biopic("Biopic"),
    Historic("Historique"),
    Opera("Opéra"),
    Cata("Catastrophe"),
    Sword("Cape et d'épée"),War("Guerre");

    private String value;

    GenreEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
