package com.epam.java.se.task5;

/**
 * Created by Мария on 24.02.2017.
 */
public class Student {
    private String name;

    public Student (String name){
        if (name==null){
            throw new IllegalArgumentException("Name can't be null");
        }
        this.name=name;
    }


    public String getName() {
        return name;
    }

}
