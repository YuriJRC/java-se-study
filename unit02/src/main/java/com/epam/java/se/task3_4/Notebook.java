package com.epam.java.se.task3_4;

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
        return "name: " + name + ", price:" + price + ", sizeX: " + sizeX
                + ", sizeY: " + sizeY + ", numberOfPages: " + numberOfPages
                + ", colorOfPages: " + colorOfPages;
    }
}
