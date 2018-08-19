create sequence SEQ_FILM;
create table film(
id bigint default SEQ_FILM.nextval primary key,
filmName varchar(250) not null,
duration varchar(20),
releaseYear date,
plot varchar(2500),
imgPath varchar(2500),
localPath varchar(2500)
);
create sequence SEQ_ACTOR;
create table actor(
id bigint default SEQ_ACTOR.nextval primary key,
firstName varchar(250) not null,
lastName varchar(250) not null
);
create table actor2film(
idfilm bigint not null,
idactor bigint not null
);
ALTER TABLE actor2film ADD PRIMARY KEY (idfilm, idactor);
 ALTER TABLE actor2film
    ADD FOREIGN KEY (idfilm)
    REFERENCES film(id);
  ALTER TABLE actor2film
     ADD FOREIGN KEY (idactor)
     REFERENCES actor(id);

create sequence SEQ_REAL;
create table realisator(
id bigint default SEQ_REAL.nextval primary key,
firstName varchar(250) not null,
lastName varchar(250) not null
);

create table real2film(
idfilm bigint not null,
idreal bigint not null
);
ALTER TABLE real2film ADD PRIMARY KEY (idfilm, idreal);
 ALTER TABLE real2film
    ADD FOREIGN KEY (idfilm)
    REFERENCES film(id);
  ALTER TABLE real2film
     ADD FOREIGN KEY (idreal)
     REFERENCES realisator(id);

create sequence SEQ_GENRE;
create table genre(
id bigint default SEQ_GENRE.nextval primary key,
name varchar(250) not null
);

create table genre2film(
idfilm bigint not null,
idGenre bigint not null
);
ALTER TABLE genre2film ADD PRIMARY KEY (idfilm, idGenre);
 ALTER TABLE genre2film
    ADD FOREIGN KEY (idfilm)
    REFERENCES film(id);
  ALTER TABLE genre2film
     ADD FOREIGN KEY (idGenre)
     REFERENCES genre(id);
