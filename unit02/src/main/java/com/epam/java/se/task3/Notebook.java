package com.epam.java.se.task3;

/**
 * Created by Мария on 23.02.2017.
 */
public class Notebook extends AbstractPaperProduct{
    private String colorOfPages;

    public Notebook (String name, int price, int numberOfPages, String colorOfPages){
        super(name, price, 30, 30, numberOfPages);
        this.colorOfPages=colorOfPages;
    }
    @Override
    public int changeNumberOfPages (int number){
         return this.numberOfPages=number;
    }

    @Override
    public String toString() {
        String format = "(name: %s, price %d, sizeX: %d, sizeY: %d, numberOfPages: %d,  colorOfPages: %s)";
        return String.format(format, name, price, sizeX, sizeY, numberOfPages, colorOfPages);
    }
}
