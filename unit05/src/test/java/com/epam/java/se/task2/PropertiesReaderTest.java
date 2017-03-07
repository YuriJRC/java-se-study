package com.epam.java.se.task2;

import org.junit.Test;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Мария on 07.03.2017.
 */
public class PropertiesReaderTest {
    @Test
    public void nullPointerExceptionCaughtTest() throws Exception {
        PropertiesReader propReader = new PropertiesReader();
        try {
            propReader.showProperties(null, null);
            propReader.showPropertyByKey("test_ru", "ru", null);
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Empty data");
        }
    }

    @Test
    public void MissingResourceTest() throws Exception {
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
            propReader.showPropertyByKey("test_en_US", "en_US", "fake");
        } catch (MissingResourceException e) {
            assertEquals(e.getMessage(), "Properties file not found");
        }
    }

    @Test
    public void propReaderTestRU() throws Exception {
        PropertiesReader propReader = new PropertiesReader();
        propReader.showProperties("test_ru", "ru");
        propReader.showPropertyByKey("test_ru", "ru", "2");
    }

    @Test
    public void propReaderTestEN() throws Exception {
        PropertiesReader propReader = new PropertiesReader();
        propReader.showProperties("test_en_US", "en_US");
        propReader.showPropertyByKey("test_en_US", "en_US", "3");
    }
}
