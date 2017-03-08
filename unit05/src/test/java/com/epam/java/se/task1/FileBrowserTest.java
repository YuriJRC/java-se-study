package com.epam.java.se.task1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileBrowserTest {
    private FileBrowser browser;

    @Before
    public void init()throws Exception {
       browser = new FileBrowser();
    }


    @Test
            (expected = FileNotFoundException.class)
    public void FileNotFoundExceptionTest() throws Exception {
        File fake = new File("fake.txt");

        browser.showAbsolutePath(fake);
        browser.goUp(fake);

    }

    @Test
    public void NullPointerExceptionCaughtTest() throws Exception {
        try {
            browser.showDirectoryContent(null);
            browser.searchOnlyTXTFiles(null);
            browser.goDown(null, null);
            browser.createNewDirectory(null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Directory not found");
        }

        try {
            browser.renameDirectory(null, null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Empty dara");
        }

        try {
            browser.showAbsolutePath(null);
            browser.goUp(null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "File not found");
        }
    }

    @Test
    public void FileNotFoundExceptionCaughtTest() throws Exception {
        File file = new File("C:\\Users\\fake\\fake");

        try {
            browser.goUp(file);
            browser.showAbsolutePath(file);
        } catch (FileNotFoundException e) {
            assertEquals(e.getMessage(), "File not found");
        }
    }

    @Test
            (expected = NotDirectoryException.class)
    public void NotDirectoryExceptionTest() throws Exception {
        File fakeDir = new File("C:\\Users\\fake\\fake");
        File fakeNewDir = new File("C:\\Users\\fake\\newFake");

        browser.renameDirectory(fakeDir, fakeNewDir);

    }

    @Test
    public void showAbsolutePathTest() throws Exception {
        File compare = new File("testfile.txt");

        browser.showAbsolutePath(compare);

        assertTrue(compare.getAbsolutePath().equals("C:\\Users\\Мария\\IdeaProjects\\unit05\\testfile.txt"));
    }

    @Test
    public void showDirectoryContentTest() throws Exception {
        File directory = new File("D:\\Application");

        browser.showDirectoryContent(directory);

        assertTrue(directory.isDirectory());

    }

    @Test
    public void searchOnlyTXTFilesTest() throws Exception {
        File directory = new File(".\\");

        browser.searchOnlyTXTFiles(directory);
    }

    @Test
    public void goUpTest() throws Exception {
        File directory = new File("C:\\Python27\\Doc");

        browser.goUp(directory);
    }

    @Test
    public void goDownTest() throws Exception {
        File directory = new File("C:\\Python27");
        String catalogue = "Doc";

        browser.goDown(directory, catalogue);
    }

    @Test
    public void createNewDirectoryTest() throws Exception {
        File newDirectory = new File("C:\\Users\\Мария\\testDir");

        browser.createNewDirectory(newDirectory);

        assertTrue(newDirectory.exists());
    }

    @Test
    public void renameDirectoryTest() throws Exception {
        File directory = new File("C:\\Users\\Мария\\testDir");
        File newDirectory = new File("C:\\Users\\Мария\\newTestDir");

        browser.renameDirectory(directory, newDirectory);

        assertTrue(newDirectory.exists());
    }

}
