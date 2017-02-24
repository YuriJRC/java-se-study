package com.epam.java.se.task5;

/**
 * Created by Мария on 22.02.2017.
 */
public class Mark <T extends Number>{
    private T mark;

    public Mark (T mark){
        this.mark=mark;
    }

    public T getMark() {
        return mark;
    }

    public void setMark(T mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "" + mark;
    }
}
