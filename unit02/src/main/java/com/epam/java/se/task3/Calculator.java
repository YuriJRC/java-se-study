package com.epam.java.se.task3;

/**
 * Created by Мария on 24.02.2017.
 */
public class Calculator extends Abacus {
    protected int numberOfFunctions;

    public Calculator(String name, int price) {
        super(name, price);
        this.type = "Electronical";
        this.numberOfFunctions=8;
    }
    @Override
    public String toString() {
        return "name: " + name + ", price:" + price + ", type: " + type
                + ", numberOfFunctions: " + numberOfFunctions;
    }
}
