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
        DirectoryBrowser browser = new DirectoryBrowser("C:\\Users\\Мария\\PycharmProjects\\untitled\\.idea");
        browser.showDirectoryContent();
    }
}
