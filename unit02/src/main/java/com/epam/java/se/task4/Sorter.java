package com.epam.java.se.task4;

import java.util.Comparator;

/**
 * Created by Мария on 23.02.2017.
 */
public class Sorter implements Comparator<Phone>{
    private CompareMethod compareMethod;

    public Sorter (CompareMethod compareMethod) {
        this.compareMethod = compareMethod;
    }

    public int compare(Phone o1, Phone o2) {
        switch (compareMethod){
            default:
            case ByPrice:
                return compareByPrice(o1, o2);
            case ByName:
                return o1.getName().compareTo(o2.getName());
            case ByPriceAndName:
                int comparedByPrice = compareByPrice(o1, o2);
                if (compareByPrice(o1, o2) == 0){
                    return o1.getName().compareTo(o2.getName());
                }
                return comparedByPrice;
        }
    }

    public int compareByPrice (Phone o1, Phone o2){
        int price1 = o1.getPrice();
        int price2 = o2.getPrice();
        if (price1 < price2){
            return -1;
        }
        else if (price1 == price2){
            return 0;
        }
        else{
            return 1;
        }
    }
}
