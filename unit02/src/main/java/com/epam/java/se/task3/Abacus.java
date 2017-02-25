package com.epam.java.se.task3;

/**
 * Created by Мария on 24.02.2017.
 */
public class Abacus extends AbstractCalculatingTool{

    public Abacus (String name, int price){
        super(name, price);
        this.type="Mechanical";
    }
    @Override
    public String toString() {
        String format = "(name: %s, price %d, type: %s)";
        return String.format(format, name, price, type);
    }
}
