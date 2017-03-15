package com.epam.java.se.task2;

import java.util.*;

/**
 * Created by Мария on 15.03.2017.
 */
public class PropertiesReader {
    private Locale loc;
    private ResourceBundle bundle;

    public void showProperties(String resource, String locale) throws MissingResourceException {
        if (resource == null || locale == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            loc = new Locale(locale);
            bundle = ResourceBundle.getBundle(resource, loc);
            ArrayList<String> keys = new ArrayList<>(Collections.list(bundle.getKeys()));
            for (String value : keys) {
                System.out.println(bundle.getString(value));
            }
        } catch (MissingResourceException e) {
            System.out.println("Properties file not found");
        }
    }

    public void showPropertyByKey(String resource, String locale, String key) throws MissingResourceException {
        if (key == null || locale == null || resource == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            loc = new Locale(locale);
            bundle = ResourceBundle.getBundle(resource, loc);
            String getKey = bundle.getString(key);
            System.out.println(getKey);
        } catch (MissingResourceException e) {
            System.out.println("Properties file or key not found");
        }
    }

}