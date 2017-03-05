package com.epam.java.se.task5;

import com.epam.java.se.task4.Actor;
import com.epam.java.se.task4.Film;
import com.epam.java.se.task4.FilmCollection;
import org.junit.Test;

/**
 * Created by Мария on 05.03.2017.
 */
public class FilmCollectionTest {
    private static final String PATH = "films_collection.ser";
    @Test
    public void addFilmTest(){
        FilmCollection films = new FilmCollection();
        films.addFilm(new Film("Titanic", "drama", 1998),
                new Actor("Leo Dicaprio"), new Actor("Kate Winslet"));
        films.addFilm(new Film("Lord of the rings", "fantasy", 2005),
                new Actor("aaa"), new Actor("bbb"), new Actor("ccc"));

        films.printFilmCollection();

        films.removeFilmByName("titanic");

        films.printFilmCollection();
//        films.printFilmCollection();
//        films.saveCollection(PATH, films);

//        FilmCollection collection = films.loadCollection(PATH);
//        collection.printFilmCollection();

    }
}
