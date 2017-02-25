package com.epam.java.se.task6;

import com.epam.java.se.task7.SubmarineAnnotation;


/**
 * Created by Мария on 25.02.2017.
 */
@SubmarineAnnotation (type = "Nuclear", location = "Saint-Petersburg")
public class Submarine {
    private String name;
    private boolean isMoving = false;
    private int speed;

    private Submarine() {}

    public String getName() {
        return name;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public int getSpeed() {
        return speed;
    }

    public static SubmarineEngine newSubmarine() {
        return new Submarine().new SubmarineEngine();
    }

    public class SubmarineEngine{

        private SubmarineEngine (){}

        public SubmarineEngine setName(String name){
            if (name ==null){
                throw new IllegalArgumentException("Name can't be null");
            }
            Submarine.this.name=name;
            return this;
        }

        public SubmarineEngine setSpeed(int speed){
            if (speed<0){
                throw new IllegalArgumentException("Speed can't be negative");
            }
            Submarine.this.speed=speed;
            return this;
        }

        public SubmarineEngine setMoving(){
            Submarine.this.isMoving=true;
            return this;
        }

        public Submarine build() {
            return Submarine.this;
        }
    }

    @Override
    public String toString() {
        String format = "Submarine: name - %s, speed - %s, isMoving - %b";
        return String.format(format, getName(), getSpeed(), isMoving());
    }
}
