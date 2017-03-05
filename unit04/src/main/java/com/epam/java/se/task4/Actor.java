package com.epam.java.se.task4;

import java.io.Serializable;

/**
 * Created by Мария on 05.03.2017.
 */
public class Actor implements Serializable{
    private static final long serialVersionUID = 2L;
    private String name;

    public Actor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String format = "%s";
        return String.format(format, name);

    }
}
