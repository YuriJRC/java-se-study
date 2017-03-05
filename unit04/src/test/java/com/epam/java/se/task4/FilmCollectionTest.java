package com.epam.java.se.task4;

import org.junit.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Мария on 05.03.2017.
 */
public class FilmCollectionTest {
    private static final String PATH = "films_collection.ser";

    @Test
            (expected = NullPointerException.class)
    public void nullPointerTest() throws Exception {
        FilmCollection films = new FilmCollection();
        films.addFilm(null);
        films.removeFilmByName(null);
        films.printFilmCollection();
        films.saveCollection(null, null);
        films.loadCollection(null);
    }

    @Test
    public void addFilmTest() throws Exception {
        FilmCollection films = new FilmCollection();

        Film film = new Film("Titanic", "drama", 1998);
        Actor actor = new Actor("Leo Dicaprio");
        Actor actor2 = new Actor("Kate Winslet");

        films.addFilm(film, actor, actor2);

        films.printFilmCollection();

        for (Map.Entry<Film, List<Actor>> entry : films.getFilmCollection().entrySet()) {
            assertTrue(entry.getKey().equals(film));
        }
    }

    @Test
    public void removeFilmTest() throws Exception {
        FilmCollection films = new FilmCollection();

        films.addFilm(new Film("Lord of the rings", "fantasy", 2005),
                new Actor("aaa"), new Actor("bbb"), new Actor("ccc"));

        Film film = new Film("Dogma", "fantasy, drama", 1999);
        films.addFilm(film, new Actor("Matt Damon"), new Actor("Ben Affleck"), new Actor("Salma Hayek"));

        films.removeFilmByName("dogma");

        films.printFilmCollection();

        assertTrue(films.getFilmCollection().size() == 1);

        for (Map.Entry<Film, List<Actor>> entry : films.getFilmCollection().entrySet()) {
            assertTrue(!entry.getKey().equals(film));
        }
    }

    @Test
    public void serialize() throws Exception {
        FilmCollection films = new FilmCollection();

        File file = new File(PATH);

        films.addFilm(new Film("Lord of the rings", "fantasy", 2005),
                new Actor("aaa"), new Actor("bbb"), new Actor("ccc"));
        films.addFilm(new Film("Titanic", "drama", 1998),
                new Actor("Leo Dicaprio"), new Actor("Kate Winslet"));
        films.addFilm(new Film("Dogma", "fantasy, drama", 1999),
                new Actor("Matt Damon"), new Actor("Ben Affleck"), new Actor("Salma Hayek"));

        films.saveCollection(PATH, films);

        assertTrue(file.exists() && file.length() > 100);
    }

    @Test
    public void deserialize() throws Exception {
        FilmCollection before = new FilmCollection();

        FilmCollection after = before.loadCollection(PATH);

        after.printFilmCollection();

        String film = "Dogma";
        Iterator<Map.Entry<Film, List<Actor>>> iter = after.getFilmCollection().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Film, List<Actor>> entry = iter.next();
            if (film.equalsIgnoreCase(entry.getKey().getTitle())) {
                assertTrue(entry.getKey().getTitle().equals(film));
            }
        }
    }

    @Test
    public void applicationLogicTest() throws Exception {
        FilmCollection first = new FilmCollection();

        first.addFilm(new Film("Lord of the rings", "fantasy", 2005),
                new Actor("aaa"), new Actor("bbb"), new Actor("ccc"));
        first.addFilm(new Film("Titanic", "drama", 1998),
                new Actor("Leo Dicaprio"), new Actor("Kate Winslet"));
        first.addFilm(new Film("Dogma", "fantasy, drama", 1999),
                new Actor("Matt Damon"), new Actor("Ben Affleck"), new Actor("Salma Hayek"));

        first.saveCollection(PATH, first);

        FilmCollection second = first.loadCollection(PATH);

        second.addFilm((new Film("V for Vendetta", "thriller", 2005)),
                new Actor("V"), new Actor("Z"), new Actor("X"), new Actor("Y"));

        second.removeFilmByName("Lord of the rings");

        second.saveCollection(PATH, second);

        FilmCollection third = second.loadCollection(PATH);

        third.printFilmCollection();

        String film1 = "Dogma";
        String film2 = "Titanic";
        String film3 = "V for Vendetta";

        Iterator<Map.Entry<Film, List<Actor>>> iter = third.getFilmCollection().entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Film, List<Actor>> entry = iter.next();
            if (entry.getKey().getTitle().equalsIgnoreCase(film1) ||
                    entry.getKey().getTitle().equalsIgnoreCase(film2) ||
                    entry.getKey().getTitle().equalsIgnoreCase(film3)) {
                assertTrue(entry.getKey().getTitle().equals(film1) ||
                        entry.getKey().getTitle().equals(film2) ||
                        entry.getKey().getTitle().equals(film3));
            }
        }
    }
}
