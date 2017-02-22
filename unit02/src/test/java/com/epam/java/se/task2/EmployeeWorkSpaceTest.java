package com.epam.java.se.task2;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Мария on 22.02.2017.
 */
public class EmployeeWorkSpaceTest {
    @Test
    public void addStationaryTest(){
        EmployeeWorkSpace workSpace = new EmployeeWorkSpace();
        workSpace.addStationery(new Stationery("Pen", 50));
        workSpace.addStationery(new Stationery("null", 100));
        workSpace.addStationery(new Stationery(null, 100));
        workSpace.addStationery(new Stationery("Paper", -200));
        workSpace.addStationery(new Stationery("Clipboard", 50));
        System.out.println(workSpace.getStationeriesList());

            assertTrue(workSpace.getStationeriesList().get(0).getPrice()==
                    workSpace.getStationeriesList().get(4).getPrice());

        assertTrue(workSpace.getStationeriesList().get(1).getName().equals("null"));
        assertTrue(workSpace.getStationeriesList().get(2).getName().equals("null"));
        assertFalse(workSpace.getStationeriesList().get(2).getName()==null);

    }
    @Test
    public void removeStationaryTest(){
        EmployeeWorkSpace workSpace = new EmployeeWorkSpace();
        workSpace.addStationery(new Stationery("Pen", 150));
        workSpace.addStationery(new Stationery("null", -500));
        workSpace.addStationery(new Stationery(null, 100));
        workSpace.addStationery(new Stationery("Paper", Integer.MAX_VALUE));
        workSpace.addStationery(new Stationery("Clipboard", 50));

        workSpace.removeStationeryByName("pen");
        workSpace.removeStationeryByName(null);
        workSpace.removeStationeryByName("null");
        workSpace.removeStationeryByName("paPER");

        System.out.println(workSpace.getStationeriesList());
    }
}
