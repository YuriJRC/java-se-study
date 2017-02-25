package com.epam.java.se.task1;

/**
 * Created by Мария on 22.02.2017.
 */
public class Pen {
    private String color;
    private String type;
    private int price;

    public Pen(String color, String type, int price) {
        if (color==null || type==null || price<0){
            throw new IllegalArgumentException("Color and type can't be null," +
                    "price can't be negative");
        }
        this.color = color;
        this.type = type;
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pen other = (Pen) obj;
        if (getColor()==null || getType()==null){
            if (other.getColor()!=null || other.getType()!=null){
                return false;
            }
        }
        else if (!(getColor().equals(other.getColor()))){
            return false;
        }
        if (getPrice()!=other.getPrice()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + getPrice();
        return result;
    }

    @Override
    public String toString() {
        return "Pen: (" + "color - " + getColor() + ", " +
                "type - " + getType() + ", " + "price - " + getPrice() + ")";
    }
}
