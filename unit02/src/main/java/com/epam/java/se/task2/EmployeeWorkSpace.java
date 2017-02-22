package com.epam.java.se.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Мария on 22.02.2017.
 */
public class EmployeeWorkSpace {
    private List<Stationery> stationeriesList;

    public EmployeeWorkSpace (){
        stationeriesList = new ArrayList<Stationery>();
    }

    public List<Stationery> getStationeriesList() {
        return stationeriesList;
    }

    public void addStationery(Stationery stationery){
        stationeriesList.add(stationery);
        }
    }

