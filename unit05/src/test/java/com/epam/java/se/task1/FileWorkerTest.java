package com.epam.java.se.task1;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileWorkerTest {
    @Test
    public void NullPointerExceptionCaughtTest() throws Exception {
        File file = new File("C:\\Users\\fake\\fake");
        String text = "Testtesttesttest";

        FileWorker worker = new FileWorker();

        try {
            worker.writeToFile(file, text);
        } catch (IOException e) {
            assertEquals(e.getMessage(), "Wrong input data");
        }
    }

    @Test
    public void FileNotFoundExceptionCaughtTest() throws Exception {
        File file = new File("C:\\Users\\fake\\fake");

        FileWorker worker = new FileWorker();

        try {
            worker.createNewFile(file);
        } catch (IOException e) {
            assertEquals(e.getMessage(), "Wrong input data");
        }

        try {
            worker.deleteFile(file);
        } catch (IOException e) {
            assertEquals(e.getMessage(), "File not found");
        }
    }

    @Test
    public void createNewFileTest()throws Exception{
        File file = new File(".\\testfile4.txt");

        FileWorker worker = new FileWorker();
        worker.createNewFile(file);

        assertTrue(file.exists());
    }

    @Test
    public void writeToFileTest() throws Exception {
        File file = new File(".\\testfile4.txt");
        String text = "Testtesttesttest";

        FileWorker worker = new FileWorker();

        worker.writeToFile(file, text);

        assertTrue(file.length()>10);
    }
    @Test
    public void deleteFileTest() throws Exception {
        File file = new File(".\\testfile5.txt");

        FileWorker worker = new FileWorker();

        worker.deleteFile(file);
    }

}
