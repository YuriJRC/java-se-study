package com.epam.java.se.task4;

/**
 * Created by Мария on 23.02.2017.
 */
public class Phone {
    private String name;
    private int price;

    public Phone(String name, int price) {
        if (name==null || price<0){
            throw new IllegalArgumentException("Name can't be null," +
                    "price can't be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
