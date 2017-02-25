package com.epam.java.se.task3;

/**
 * Created by Мария on 23.02.2017.
 */
public class OfficePaper extends AbstractPaperProduct{
    private int paperThickness;
    private String format;

    public OfficePaper (String name, int price, int paperThickness, String format){
        super(name, price, 200, 200, 300);
        this.paperThickness=paperThickness;
        this.format=format;
    }
    @Override
    public int changeNumberOfPages (int number){
        return number;
    }


    @Override
    public String toString() {
        String format = "(name: %s, price %d, sizeX: %d, sizeY: %d, numberOfPages: %d,  format: %s)";
        return String.format(format, name, price, sizeX, sizeY, numberOfPages, this.format);
    }
}
