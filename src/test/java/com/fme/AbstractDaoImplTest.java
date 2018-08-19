package com.fme;

import com.fme.constant.GenreEnum;
import com.fme.main.Application;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class,DatabaseConfig.class})
@Transactional
@Category(IntegrationTest.class)
public abstract class AbstractDaoImplTest  {

    protected Long idFilm;
    protected Long idReal;
    protected Long idActor;
    protected Long idGenre;
    protected static final String FILM_NAME="full metal jacket";
    protected static final String REALISATOR_NAME="kubrick";
    protected static final String ACTOR_NAME="kubrick";
    protected static final DateTimeFormatter FORMATTER=DateTimeFormatter.ofPattern("dd/MM/uuuu");
    protected static final LocalDate RELEASE_YEAR=LocalDate.parse("01/01/1987", FORMATTER);
    protected static final GenreEnum GENRE=GenreEnum.War;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Before
    public void setUp() throws Exception {

        final Object[] filmParam = {FILM_NAME};
        final Object[] filmInsertParam = {FILM_NAME, "2h30", RELEASE_YEAR, "plot", "/fmess/tmp/img.png", "/fmess/tmp/"};
        final Object[] realisatorParam = {REALISATOR_NAME};
        final Object[] actorParam = {ACTOR_NAME};
        final Object[] genreParam = {GENRE.getValue()};
        this.jdbcTemplate.update("insert into realisator values (seq_real.nextval,'stan',?);", realisatorParam);
        this.jdbcTemplate.update("insert into film  values (seq_film.nextval,?,?,?,?,?,?);", filmInsertParam);
        idFilm = this.jdbcTemplate.queryForObject("select id from film where filmName=?", filmParam, Long.class);
        idReal = this.jdbcTemplate.queryForObject("select id from realisator where lastName=?", realisatorParam, Long.class);
        this.jdbcTemplate.update("insert into real2film values(?,?)", preparedStatement -> {
            preparedStatement.setLong(1, idFilm);
            preparedStatement.setLong(2, idReal);
        });
        this.jdbcTemplate.update("insert into actor values (seq_actor.nextval,'richard',?);", actorParam);
        idActor = this.jdbcTemplate.queryForObject("select id from actor where lastName=?", actorParam, Long.class);
        this.jdbcTemplate.update("insert into actor2film values(?,?)", preparedStatement -> {
            preparedStatement.setLong(1, idFilm);
            preparedStatement.setLong(2, idActor);
        });
        this.jdbcTemplate.update("insert into genre values (seq_actor.nextval,?);", genreParam);
        idGenre = this.jdbcTemplate.queryForObject("select id from genre where name=?", genreParam, Long.class);
        this.jdbcTemplate.update("insert into genre2film values(?,?)", preparedStatement -> {
            preparedStatement.setLong(1, idFilm);
            preparedStatement.setLong(2, idGenre);
        });
    }


}