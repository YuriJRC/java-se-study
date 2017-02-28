package com.epam.java.se.task3;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Мария on 23.02.2017.
 */
public class BeginnersSetTest {
    @Test
    public void valuesThatNotFollowContract()throws Exception{
        Notebook n = new Notebook("Notebook", -20, 300, "black");

        assertFalse(n.getPrice()==-20);
    }
    @Test
    public void notNullTest() throws Exception{
        BeginnersSet b = new BeginnersSet();
        for (int i=0; i<b.size(); i++) {
            assertTrue(b.get(i)!=null);
        }
    }
    @Test
    public void paperProductTest() throws Exception{
        Notebook n = new Notebook("Notebook", 20, 300, "black");
        n.changeNumberOfPages(50);
        System.out.println(n.toString());

        assertTrue(n.getName().equals("Notebook"));
        assertTrue(n.getNumberOfPages()==50);

    }
    @Test
    public void calculationToolTest() throws Exception{
        EngineerCalculator e = new EngineerCalculator("Casio", 1000, 7);
        e.setNumberOfExtendedFunctions(8);
        assertTrue(e.getNumberOfExtendedFunctions()==8);

    }
    @Test
    public void beginnersSetTest() throws Exception{
        BeginnersSet b = new BeginnersSet();

        System.out.println(b);

        assertTrue(b.get(2).getName().equals("Casio"));
    }
}
