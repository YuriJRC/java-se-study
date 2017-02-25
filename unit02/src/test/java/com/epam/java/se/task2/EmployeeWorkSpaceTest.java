package com.epam.java.se.task2;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Мария on 22.02.2017.
 */
public class EmployeeWorkSpaceTest {
    @Test
    public void contractTest() throws Exception{
        EmployeeWorkSpace workSpace = new EmployeeWorkSpace();
        workSpace.addStationery(new Stationery(null, 100));
        workSpace.addStationery(new Stationery("Paper", -200));

        assertFalse(workSpace.getStationeriesList().get(0).getName().equals("null"));
        assertFalse(workSpace.getStationeriesList().get(1).getPrice()==-200);
    }
    @Test
    public void nullTest()throws Exception{
        EmployeeWorkSpace workSpace = new EmployeeWorkSpace();
        workSpace.addStationery(new Stationery("Pen", 500));

        assertTrue(workSpace.getStationeriesList().get(0)!=null);
    }

    @Test
    public void addStationaryTest()throws Exception{
        EmployeeWorkSpace workSpace = new EmployeeWorkSpace();
        workSpace.addStationery(new Stationery("Pen", 50));
        workSpace.addStationery(new Stationery("null", 100));
        workSpace.addStationery(new Stationery("Clipboard", 50));
        System.out.println(workSpace.getStationeriesList());

            assertTrue(workSpace.getStationeriesList().get(0).getPrice()==
                    workSpace.getStationeriesList().get(2).getPrice());
        assertTrue(workSpace.getStationeriesList().get(1).getName().equals("null"));
        assertTrue(workSpace.getStationeriesList().get(2).getName().equals("Clipboard"));

    }
    @Test
    public void removeStationaryTest()throws Exception{
        EmployeeWorkSpace workSpace = new EmployeeWorkSpace();
        workSpace.addStationery(new Stationery("Pen", 150));
        workSpace.addStationery(new Stationery("null", 500));
        workSpace.addStationery(new Stationery("Paper", Integer.MAX_VALUE));
        workSpace.addStationery(new Stationery("Clipboard", 50));
        workSpace.removeStationeryByName("pen");
        workSpace.removeStationeryByName("null");
        workSpace.removeStationeryByName("paPER");

        EmployeeWorkSpace workSpace2 = new EmployeeWorkSpace();
        workSpace2.addStationery(new Stationery("Clipboard", 50));

        assertEquals(workSpace.getStationeriesList().get(0).getName(), workSpace2.getStationeriesList().get(0).getName());
    }

    @Test
    public void calculateSumTest()throws Exception{
        EmployeeWorkSpace workSpace = new EmployeeWorkSpace();
        workSpace.addStationery(new Stationery("Pen", 150));
        workSpace.addStationery(new Stationery("null", 500));
        workSpace.addStationery(new Stationery("Paper", Integer.MAX_VALUE));
        workSpace.addStationery(new Stationery("Clipboard", 50));

        assertTrue(workSpace.calculateSum()==Integer.MAX_VALUE);

    }

}
