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
        return "name: " + name + ", price:" + price + ", type: " + type;
    }
}
