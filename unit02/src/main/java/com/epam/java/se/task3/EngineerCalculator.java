package com.epam.java.se.task3;

/**
 * Created by Мария on 24.02.2017.
 */
public class EngineerCalculator extends Calculator{
    private int numberOfExtendedFunctions;

    public EngineerCalculator (String name, int price, int numberOfExtendedFunctions){
        super(name, price);
        this.type = "Electronical";
        this.numberOfFunctions=12;
        this.numberOfFunctions=numberOfExtendedFunctions;
    }

    public void setNumberOfExtendedFunctions(int numberOfExtendedFunctions) {
        if (numberOfExtendedFunctions<0){
            numberOfExtendedFunctions=0;
        }
        this.numberOfExtendedFunctions = numberOfExtendedFunctions;
    }

    public int getNumberOfExtendedFunctions() {
        return numberOfExtendedFunctions;
    }
    @Override
    public String toString() {
        String format = "(name: %s, price %d, type: %s, " +
                "numberOfFunctions: %d, numberOfExtendedFunctions: %d)";
        return String.format(format, name, price, type, numberOfFunctions, numberOfExtendedFunctions);
    }
}
