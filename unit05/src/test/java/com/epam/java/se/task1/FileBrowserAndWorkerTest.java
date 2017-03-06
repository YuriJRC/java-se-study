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
    public void FileNotFoundExceptionTest() throws Exception{
        File fake = new File("fake.txt");

        FileBrowser browser = new FileBrowser();

        browser.showAbsolutePath(fake);

    }

    @Test
    public void showAbsolutePathTest()throws Exception{
        File compare = new File("testfile.txt");

        FileBrowser browser = new FileBrowser();
        browser.showAbsolutePath(compare);

        assertTrue(compare.getAbsolutePath().equals("C:\\Users\\Мария\\IdeaProjects\\unit05\\testfile.txt"));
    }


}
