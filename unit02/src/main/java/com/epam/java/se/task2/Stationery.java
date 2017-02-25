package com.epam.java.se.task2;

/**
 * Created by Мария on 22.02.2017.
 */
public class Stationery {
    private int id;
    protected String name;
    protected int price;
    private static int staticId;

    public Stationery (String name, int price){
        if (name==null || price<0){
            throw new IllegalArgumentException("Name can't be null," +
                    "price can't be negative");
        }
        this.name=name;
        this.price=price;
        id =staticId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String format = "(id - %d, name - %s, price - %d)";
        return String.format(format, getId(), getName(), getPrice());
    }
}
