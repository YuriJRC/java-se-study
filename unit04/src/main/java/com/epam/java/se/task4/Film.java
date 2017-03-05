package com.epam.java.se.task4;

import java.io.Serializable;

/**
 * Created by Мария on 05.03.2017.
 */
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String genre;
    private int date;

    public Film(String title, String genre, int date) {
        this.title = title;
        this.genre = genre;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        String format = "title - %s, genre - %s, date - %d";
        return String.format(format, title, genre, date);
    }
}
