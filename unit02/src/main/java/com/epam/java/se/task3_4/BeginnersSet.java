package com.epam.java.se.task3_4;

import com.epam.java.se.task2.Stationery;

import java.util.ArrayList;

/**
 * Created by Мария on 23.02.2017.
 */
public class BeginnersSet extends ArrayList <Stationery>{

    public BeginnersSet (){
        add(new Notebook("Notebook", 500, 20, "yellow"));
        add(new OfficePaper("Svetocopy", 400, 3, "A4"));
    }

}
