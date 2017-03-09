package com.epam.java.se.task1;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Мария on 06.03.2017.
 */
public class DirectoryBrowserTest {
    private DirectoryBrowser browser;

    @Before
    public void init() throws Exception {
        browser = new DirectoryBrowser();
    }

    @Test
    public void NullPointerExceptionCaughtTest() throws Exception {
        try {
            browser.renameDirectory(null);
            browser.createNewDirectory(null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Wrong path or directory");
        }
    }
    @Test
    public void showCurrentDirectoryTest() throws Exception {
        String currentDir = "C:\\Users\\Мария\\IdeaProjects\\unit05";
        browser.showCurrentDirectory();

        assertTrue(currentDir.equals(browser.getDirectoryToString()));
    }
    @Test
    public void showDirectoryContentTest() throws Exception{
        File file = new File(System.getProperty("user.dir"));
        browser.showDirectoryContent();

        assertTrue(file.exists() && file.isDirectory());

    }

    @Test
    public void goUpTest() throws Exception{
        File compare = new File("C:\\Users\\Мария\\IdeaProjects");

        browser.goUp();

        assertEquals(compare.toString(), browser.getDirectoryToString());
    }

    @Test
    public void goDownTest() throws Exception{
        File compare = new File("C:\\Users\\Мария\\IdeaProjects\\unit05\\target");

        browser.goDown("target");

        assertEquals(compare.toString(), browser.getDirectoryToString());
    }

    @Test
    public void changeDirectoryTest() throws Exception{
        File compare = new File("C:\\Games");

        browser.changeDirectory("C:\\Games");

        assertEquals(compare.toString(), browser.getDirectoryToString());
    }

    @Test
    public void createNewDirectoryTest() throws Exception{
        File compare = new File("C:\\Games\\test");

        browser.changeDirectory("C:\\Games");
        browser.createNewDirectory("test");

        assertTrue(compare.exists() && compare.isDirectory());
    }

    @Test
    public void renameDirectoryTest() throws Exception{
        File compare = new File("C:\\Games\\testtest");

        browser.changeDirectory("C:\\Games");
        browser.createNewDirectory("test");
        browser.renameDirectory("testtest");

        assertTrue(compare.exists() && compare.isDirectory());
    }
}
