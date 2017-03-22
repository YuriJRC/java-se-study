package com.epam.java.se.task2;

import org.junit.Before;
import org.junit.Test;

import java.util.MissingResourceException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Мария on 15.03.2017.
 */
public class PropertiesReaderTest {
    private PropertiesReader propReaderENG;
    private PropertiesReader propReaderRUS;

    @Before
    public void init() throws Exception {
        propReaderENG = new PropertiesReader("test_en_US", "en_US", "3");
        propReaderRUS = new PropertiesReader("test_ru", "ru", "2");
    }

    @Test
    public void nullPointerExceptionCaughtTest() throws Exception {
        try {
            propReaderENG = new PropertiesReader(null, null, null);
            propReaderENG.getProperties();
            propReaderENG.getPropertyByKey();
            propReaderENG.showResult();
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Empty data");
        }
    }

    @Test
    public void MissingResourceExceptionCaughtTest() throws Exception {
        try {
            propReaderRUS = new PropertiesReader("d", "en_US");
            propReaderRUS.getProperties();
        } catch (MissingResourceException e) {
            assertEquals(e.getMessage(), "Properties file not found");
        }
    }

    @Test
    public void MissingKeyTest() throws Exception {
        try {
            propReaderENG = new PropertiesReader("test_en_US", "en_US", "fake");
            propReaderENG.getPropertyByKey();
        } catch (MissingResourceException e) {
            assertEquals(e.getMessage(), "Properties file or key not found");
        }
    }

    @Test
    public void propReaderTestRU() throws Exception {
        propReaderRUS.getProperties();
        propReaderRUS.showResult();
    }

    @Test
    public void propReaderTestEN() throws Exception {
        propReaderENG.getProperties();
        propReaderENG.showResult();
    }
}