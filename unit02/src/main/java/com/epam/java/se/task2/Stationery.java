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
        this.name=name;
        this.price=price;
        id =staticId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        if (name == null){
            return "null";
        }
        return name;
    }

    public int getPrice() {
        if (price<0){
            return 0;
        }
        return price;
    }

    @Override
    public String toString() {
        return "(" + "id: "+ getId() +", "+"name - " + getName() + ", " + "price - " + getPrice() + ")";
    }
}
