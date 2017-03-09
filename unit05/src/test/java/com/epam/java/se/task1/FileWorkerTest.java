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
    private DirectoryBrowser browser;
    private FileWorker worker;

    @Before
    public void init() throws Exception {
        worker = new FileWorker();
        browser = new DirectoryBrowser();
    }

    @Test
    public void NullPointerExceptionCaughtTest() throws Exception {
        try {
            worker.showFilePath(null, null);
            worker.searchOnlyTXTFiles(null);
            worker.createNewFile(null, null);
            worker.readFromFile(null, null);
            worker.writeToFile(null, null, null, null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "File not found");
        }
    }

    @Test
    public void FileNotFoundExceptionCaughtTest() throws Exception {
        File file = new File("C:\\Users\\fake\\fake");
        String text = "Testtesttesttest";
        String filename = "fake.txt";

        try {
            worker.writeToFile(file, filename, "true", text);
            worker.createNewFile(file, text);

        } catch (FileNotFoundException e) {
            assertEquals(e.getMessage(), "File not found or wrong data");
        }
    }

    @Test
    public void IOExceptionCaughtTest() throws Exception {
        File file = new File("C:\\Users\\fake\\fake");
        String filename = "fake.txt";

        try {
            worker.readFromFile(file, filename);
            worker.deleteFile(file, filename);
        } catch (IOException e) {
            assertEquals(e.getMessage(), "File not found");
        }
    }

    @Test
    public void createNewFileTest() throws Exception {
        File compare = new File("C:\\Games\\test.txt");

        browser.changeDirectory("C:\\Games");

        worker.createNewFile(browser.getDirectory(), "test.txt");

        assertTrue(compare.exists() && compare.isFile());
    }

    @Test
    public void deleteFileTest() throws Exception {
        File compare = new File("C:\\Games\\test.txt");

        browser.changeDirectory("C:\\Games");

        worker.deleteFile(browser.getDirectory(), "test.txt");

        assertTrue(!compare.exists() && !compare.isFile());

    }

    @Test
    public void showFilePathTest() throws Exception {
        File compare = new File("C:\\Games\\test.txt");

        browser.changeDirectory("C:\\Games\\test");

        worker.showFilePath(browser.getDirectory(), "test.txt");

        assertTrue(compare.exists() && compare.isFile());
    }

    @Test
    public void searchOnlyTXTFilesTest() throws Exception {
        File compare = new File("C:\\Users\\Мария\\IdeaProjects\\unit05\\testfile.txt");

        worker.searchOnlyTXTFiles(browser.getDirectory());

        assertTrue(compare.exists() && compare.isFile());
    }

    @Test
    public void writeToFileTest() throws Exception {
        File file = new File(".\\testfile2.txt");
        String append = "true";
        String text = "Testtesttesttest";

        worker.writeToFile(browser.getDirectory(), file.toString(), append, text);

        assertTrue(file.length()>10);
    }

    @Test
    public void readFromFileTest() throws Exception {
        File file = new File(".\\testfile3.txt");

        worker.readFromFile(browser.getDirectory(), file.toString());

        assertTrue(file.exists() && file.length()>5);
    }
}
