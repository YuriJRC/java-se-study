package com.epam.java.se.task3;

import com.epam.java.se.task2.Stationery;

/**
 * Created by Мария on 24.02.2017.
 */
public class AbstractCalculatingTool extends Stationery{
    protected String type;

    public AbstractCalculatingTool(String name, int price){
        super(name, price);
        this.price=price;
    }
}
