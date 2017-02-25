package com.epam.java.se.task6;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Мария on 25.02.2017.
 */
public class SubmarineTest {
    @Test
    public void build() throws Exception{
        Submarine submarine = Submarine.newSubmarine()
                .setName("Yellow submarine")
                .setSpeed(50)
                .setMoving()
                .build();

        System.out.println(submarine.toString());

        assertTrue(submarine.isMoving());
    }
}
