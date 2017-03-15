package com.epam.java.se.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.MissingResourceException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Мария on 15.03.2017.
 */
public class PropertiesReaderTest {
    private PropertiesReader propReader;

    @Before
    public void init()throws Exception {
        propReader = new PropertiesReader();
    }

    @Test
    public void nullPointerExceptionCaughtTest() throws Exception {
        try {
            propReader.getProperties(null, null);
            propReader.getPropertyByKey("test_ru", "ru", null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Empty data");
        }
    }

    @Test
    public void MissingResourceTest() throws Exception {
        try {
            propReader.getProperties("d", "en_US");
        } catch (MissingResourceException e) {
            assertEquals(e.getMessage(), "Properties file not found");
        }
    }

    @Test
    public void MissingKeyTest() throws Exception {
        try {
            propReader.getPropertyByKey("test_en_US", "en_US", "fake");
        } catch (MissingResourceException e) {
            assertEquals(e.getMessage(), "Properties file or key not found");
        }
    }

    @Test
    public void propReaderTestRU() throws Exception {
        System.out.println(propReader.getProperties("test_ru", "ru"));
        System.out.println(propReader.getPropertyByKey("test_ru", "ru", "2"));
    }

    @Test
    public void propReaderTestEN() throws Exception {
        System.out.println(propReader.getProperties("test_en_US", "en_US"));
        System.out.println(propReader.getPropertyByKey("test_en_US", "en_US", "3"));
    }
}