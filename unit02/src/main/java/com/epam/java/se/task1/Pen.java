package com.epam.java.se.task1;

/**
 * Created by Мария on 22.02.2017.
 */
public class Pen {
    private String color;
    private String type;
    private int price;

    public Pen(String color, String type, int price) {
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
        if (price<0){
            return 0;
        }
        return price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

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
}
