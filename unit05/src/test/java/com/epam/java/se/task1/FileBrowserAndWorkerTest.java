package com.epam.java.se.task1;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileBrowserAndWorkerTest {
    @Test
            (expected = FileNotFoundException.class)
    public void FileNotFoundExceptionTest() throws Exception {
        File fake = new File("fake.txt");

        FileBrowser browser = new FileBrowser();

        browser.showAbsolutePath(fake);

    }

    @Test
    public void NullPointerExceptionTest() throws Exception {
        File fake = new File("fake.txt");

        FileBrowser browser = new FileBrowser();

        try {
            browser.showDirectoryContent(fake);
            browser.searchOnlyTXTFiles(fake);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Directory not found");
        }
    }

    @Test
    public void showAbsolutePathTest() throws Exception {
        File compare = new File("testfile.txt");

        FileBrowser browser = new FileBrowser();
        browser.showAbsolutePath(compare);

        assertTrue(compare.getAbsolutePath().equals("C:\\Users\\Мария\\IdeaProjects\\unit05\\testfile.txt"));
    }

    @Test
    public void showDirectoryContentTest() throws Exception {
        File directory = new File("D:\\Application");

        FileBrowser browser = new FileBrowser();

        browser.showDirectoryContent(directory);

        assertTrue(directory.isDirectory());

    }
    @Test
    public void searchOnlyTXTFilesTest() throws Exception{
        File directory = new File(".\\");

        FileBrowser browser = new FileBrowser();

        browser.searchOnlyTXTFiles(directory);


    }


}
