package com.epam.java.se.task1;

import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileBrowserTest {
    @Test
            (expected = FileNotFoundException.class)
    public void FileNotFoundExceptionTest() throws Exception {
        File fake = new File("fake.txt");

        FileBrowser browser = new FileBrowser();

        browser.showAbsolutePath(fake);
        browser.goUp(fake);

    }

    @Test
    public void NullPointerExceptionCaughtTest() throws Exception {
        FileBrowser browser = new FileBrowser();
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
            browser.goUp(null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "File not found");
        }

    }
    @Test
            (expected = NotDirectoryException.class)
    public void NotDirectoryExceptionTest() throws Exception{
        File fakeDir = new File("C:\\Users\\fake\\fake");
        File fakeNewDir = new File("C:\\Users\\fake\\newFake");

        FileBrowser browser = new FileBrowser();

        browser.renameDirectory(fakeDir, fakeNewDir);

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
    public void searchOnlyTXTFilesTest() throws Exception {
        File directory = new File(".\\");

        FileBrowser browser = new FileBrowser();

        browser.searchOnlyTXTFiles(directory);
    }

    @Test
    public void goUpTest() throws Exception {
        File directory = new File("C:\\Python27\\Doc");

        FileBrowser browser = new FileBrowser();

        browser.goUp(directory);
    }

    @Test
    public void goDownTest() throws Exception {
        File directory = new File("C:\\Python27");
        String catalogue = "Doc";

        FileBrowser browser = new FileBrowser();

        browser.goDown(directory, catalogue);
    }

    @Test
    public void createNewDirectoryTest() throws Exception {
        File newDirectory = new File("C:\\Users\\Мария\\testDir");

        FileBrowser browser = new FileBrowser();

        browser.createNewDirectory(newDirectory);

        assertTrue(newDirectory.exists());
    }
    @Test
    public void renameDirectoryTest() throws Exception {
        File directory = new File("C:\\Users\\Мария\\testDir");
        File newDirectory = new File("C:\\Users\\Мария\\newTestDir");

        FileBrowser browser = new FileBrowser();

        browser.renameDirectory(directory, newDirectory);

        assertTrue(newDirectory.exists());
    }

}
