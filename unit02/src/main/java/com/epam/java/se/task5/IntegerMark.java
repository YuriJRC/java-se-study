package com.epam.java.se.task5;

/**
 * Created by Мария on 24.02.2017.
 */
public interface IntegerMark<T extends Integer>{
    void addMark(Student name, T number);
}
