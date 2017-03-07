package com.epam.java.se.task2;

import org.junit.Test;

import java.util.MissingResourceException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Мария on 07.03.2017.
 */
public class PropertiesReaderTest {
    @Test
    public void nullPointerExceptionCaughtTest() throws Exception {
        PropertiesReader propReader = new PropertiesReader();
        try {
            propReader.showProperties(null, null);
            propReader.showPropByKey("test_ru", "ru", null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Empty data");
        }
    }

    @Test
    public void MissingResourceCaughtTest() throws Exception {
        PropertiesReader propReader = new PropertiesReader();

        try {
            propReader.showProperties("d", "en_US");
        } catch (MissingResourceException e) {
            assertEquals(e.getMessage(), "Properties file not found");
        }
    }

    @Test
    public void MissingKeyTest() throws Exception {
        PropertiesReader propReader = new PropertiesReader();

        try {
            propReader.showPropByKey("test_en_US", "en_US", "fake");
        } catch (MissingResourceException e) {
            assertEquals(e.getMessage(), "Properties file not found");
        }
    }

    @Test
    public void propReaderTestRU() throws Exception {
        PropertiesReader propReader = new PropertiesReader();
        propReader.showProperties("test_ru", "ru");
    }

    @Test
    public void propReaderTestEN() throws Exception {
        PropertiesReader propReader = new PropertiesReader();
        propReader.showProperties("test_en_US", "en_US");
    }
}
