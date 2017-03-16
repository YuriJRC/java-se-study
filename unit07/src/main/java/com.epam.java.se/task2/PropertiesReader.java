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
    private String resource;
    private String locale;
    private String key;

    public PropertiesReader(String resource, String locale){
        run = true;
        this.resource=resource;
        this.locale=locale;
    }

    public PropertiesReader(String resource, String locale, String key){
        run = true;
        this.resource=resource;
        this.locale=locale;
        this.key=key;
    }

    public String getProperties() throws MissingResourceException {
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

    public String getPropertyByKey() throws MissingResourceException {
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
        if (builder==null){
            throw new NullPointerException("Empty data");
        }
        System.out.println(getName() + "\n" + builder);
    }

    public void run() {
        try {
            while (run) {
                System.out.println(getName() + "is reading\n");
                Thread.sleep(500);
                getProperties();
                interrupt();
            }
        } catch (InterruptedException e){
            showResult();
            stopThread();
        }
    }

    public void stopThread() {
        run = false;
        System.out.println(getName() + "completed reading\n");
    }

}