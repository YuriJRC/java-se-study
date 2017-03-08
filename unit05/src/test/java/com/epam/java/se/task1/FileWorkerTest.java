package com.epam.java.se.task1;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileWorkerTest {
    private FileWorker worker;

    @Before
    public void init()throws Exception {
        worker = new FileWorker();
    }

    @Test
    public void NullPointerExceptionCaughtTest() throws Exception{

        try {
            worker.createNewFile(null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Wrong input data");
        }

        try {
            worker.deleteFile(null);
            worker.writeToFile(null, null);
            worker.readFromFile(null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "File not found");
        }
    }

    @Test
    public void FileNotFoundExceptionCaughtTest() throws Exception {
        File file = new File("C:\\Users\\fake\\fake");
        String text = "Testtesttesttest";

        try {
            worker.writeToFile(file, text);
        } catch (FileNotFoundException e) {
            assertEquals(e.getMessage(), "Wrong input data");
        }
    }

    @Test
    public void IOExceptionCaughtTest() throws Exception {
        File file = new File("C:\\Users\\fake\\fake");

        try {
            worker.readFromFile(file);
            worker.deleteFile(file);
        } catch (IOException e) {
            assertEquals(e.getMessage(), "File not found");
        }

        try {
            worker.createNewFile(file);
        } catch (IOException e) {
            assertEquals(e.getMessage(), "Wrong input data");
        }


    }

    @Test
    public void createNewFileTest()throws Exception{
        File file = new File(".\\testfile4.txt");

        worker.createNewFile(file);

        assertTrue(file.exists());
    }

    @Test
    public void writeToFileTest() throws Exception {
        File file = new File(".\\testfile4.txt");
        String text = "Testtesttesttest";

        worker.writeToFile(file, text);

        assertTrue(file.length()>10);
    }

    @Test
    public void deleteFileTest() throws Exception {
        File file = new File(".\\testfile5.txt");

        worker.deleteFile(file);
    }

    @Test
    public void readFromFileTest() throws Exception {
        File file = new File(".\\testfile4.txt");

        worker.readFromFile(file);
    }

}
