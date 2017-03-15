package com.epam.java.se.task2;

import java.util.*;

/**
 * Created by Мария on 15.03.2017.
 */
public class PropertiesReader extends Thread {
    private Locale loc;
    private ResourceBundle bundle;
    private StringBuilder builder;
    private boolean run;

    public PropertiesReader(){
        run = true;
    }

    public String getProperties(String resource, String locale) throws MissingResourceException {
        builder = new StringBuilder();
        if (resource == null || locale == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            loc = new Locale(locale);
            bundle = ResourceBundle.getBundle(resource, loc);
            ArrayList<String> keys = new ArrayList<>(Collections.list(bundle.getKeys()));
            for (String value : keys) {
                builder.append(bundle.getString(value)).append("\n");
            }
        } catch (MissingResourceException e) {
            System.out.println("Properties file not found");
        }
        return builder.toString();
    }

    public String getPropertyByKey(String resource, String locale, String key) throws MissingResourceException {
        builder = new StringBuilder();
        if (key == null || locale == null || resource == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            loc = new Locale(locale);
            bundle = ResourceBundle.getBundle(resource, loc);
            String getKey = bundle.getString(key);
            builder.append(getKey);
        } catch (MissingResourceException e) {
            System.out.println("Properties file or key not found");
        }
        return builder.toString();
    }
    public void showResult(){
        System.out.println("Thread " + getName() + "\n" + builder + "\n");
    }

    public void run() {
            while (run) {
                System.out.println("Thread " + getName() + "completed reading\n" );
                stopThread();
            }
    }

    public void stopThread() {
        run = false;
    }

}