package com.epam.java.se.task5;

/**
 * Created by Мария on 24.02.2017.
 */
public class Student {
    private String name;
    private String surname;

    public Student (String name, String surname){
        if (name==null || surname==null){
            throw new IllegalArgumentException("Name can't be null");
        }
        this.name=name;
        this.surname=surname;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
