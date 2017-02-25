package com.epam.java.se.task4;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

/**
 * Created by Мария on 23.02.2017.
 */
public class CollectionsSortTest {
    @Test
    public void collectionsSort() throws Exception{
        Comparator<Phone> comparatorByName = new Sorter(CompareMethod.ByName);
        Comparator<Phone> comparatorByPrice = new Sorter(CompareMethod.ByPrice);
        Comparator<Phone> comparatorByPriceAndName  = new Sorter(CompareMethod.ByPriceAndName);

        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Samsung", 160));
        phones.add(new Phone("Samsung", 150));
        phones.add(new Phone("IPhone", 250));
        phones.add(new Phone("Asus", 200));
        phones.add(new Phone("LG", 200));
        Collections.sort(phones, comparatorByName);

        List<Phone> phones2 = new ArrayList<>();
        phones2.add(new Phone("Samsung", 150));
        phones2.add(new Phone("IPhone", 250));
        phones2.add(new Phone("Asus", 200));
        phones2.add(new Phone("LG", 200));
        phones2.add(new Phone("Sony", 200));
        Collections.sort(phones2, comparatorByPrice);

        List<Phone> phones3 = new ArrayList<>();
        phones3.add(new Phone("Samsung", 150));
        phones3.add(new Phone("IPhone", 250));
        phones3.add(new Phone("LG", 200));
        phones3.add(new Phone("Samsung2", 150));
        phones3.add(new Phone("Asus", 200));
        phones3.add(new Phone("Samsung", 150));
        Collections.sort(phones3, comparatorByPriceAndName);

        for (int i=0; i<phones.size(); i++) {
            System.out.println(phones.get(i).getName() + " " + phones.get(i).getPrice());
            assertTrue(phones.get(0).getName().equals("Asus"));
            assertTrue(phones.get(4).getName().equals("Samsung"));
        }

        System.out.println();
        for (int i=0; i<phones2.size(); i++) {
            System.out.println(phones2.get(i).getName() + " " + phones2.get(i).getPrice());
            assertTrue(phones2.get(0).getPrice()==150);
            assertTrue(phones2.get(4).getPrice()==250);
        }

        System.out.println();
        for (int i=0; i<phones3.size(); i++) {
            System.out.println(phones3.get(i).getName() + " " + phones3.get(i).getPrice());
            assertTrue(phones3.get(2).getName().equals("Samsung2") &&
                    phones3.get(2).getPrice()==150);
        }


    }
}
