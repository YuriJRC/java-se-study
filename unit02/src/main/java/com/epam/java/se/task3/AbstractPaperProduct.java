package com.epam.java.se.task3;

import com.epam.java.se.task2.Stationery;

/**
 * Created by Мария on 23.02.2017.
 */
public abstract class AbstractPaperProduct extends Stationery{
    protected int sizeX;
    protected int sizeY;
    protected int numberOfPages;

    public AbstractPaperProduct (String name, int price, int sizeX, int sizeY, int numberOfPages){
        super(name, price);
        this.sizeX=sizeX;
        this.sizeY=sizeY;
        this.numberOfPages=numberOfPages;
    }
    public abstract int changeNumberOfPages(int number);
}
