package com.epam.java.se.task4;

import java.io.*;
import java.util.*;

/**
 * Created by Мария on 05.03.2017.
 */
public class FilmCollection implements Serializable {
    private static final long serialVersionUID = 3L;
    private HashMap<Film, List<Actor>> films;
    private FilmCollection collection;

    public FilmCollection() {
        films = new HashMap<>();
    }

    public void addFilm(Film film, Actor... actors) {
        if (film == null || actors == null) {
            throw new NullPointerException("Empty data");
        }
        ArrayList actorsInFilm = new ArrayList();
        for (Actor a : actors) {
            actorsInFilm.add(a);
        }
        films.put(film, actorsInFilm);
    }

    public void removeFilmByName(String name) {
        if (name == null) {
            throw new NullPointerException("Empty data");
        }
        Iterator<Map.Entry<Film, List<Actor>>> iter = films.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Film, List<Actor>> entry = iter.next();
            if (name.equalsIgnoreCase(entry.getKey().getTitle())) {
                iter.remove();
            }
        }
    }

    public void printFilmCollection() {
        if (films == null) {
            throw new NullPointerException("Empty data");
        }
        for (Map.Entry f : films.entrySet()) {
            System.out.println(f.getKey() + " " + f.getValue());
        }
    }

    public void saveCollection(String filePath, FilmCollection collection) {
        if (filePath == null || collection == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(filePath));
            objectWriter.writeObject(collection);
            objectWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public FilmCollection loadCollection(String filePath) {
        if (filePath == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(filePath));
            collection = (FilmCollection) objectReader.readObject();
            objectReader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        return collection;
    }


}
