package com.epam.java.se.task1;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileWorkerTest {
    @Test
    public void NullPointerExceptionCatchTest() throws Exception {
        File file = new File("C:\\Users\\fake\\fake");

        FileWorker worker = new FileWorker();

        try {
            worker.createNewFile(file);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Wrong input data");
        }


    }
    @Test
    public void createNewFileTest()throws Exception{
        File file = new File(".\\testfile4.txt");


        FileWorker worker = new FileWorker();
        worker.createNewFile(file);

        assertTrue(file.exists());
    }
}
