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
        return 300;
    }
    @Override
    public String toString() {
        return "name: " + name + ", price:" + price + ", sizeX: " + sizeX
                + ", sizeY: " + sizeY + ", numberOfPages: " + numberOfPages
                + ", format: " + format;
    }
}
