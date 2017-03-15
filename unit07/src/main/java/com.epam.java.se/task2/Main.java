package com.epam.java.se.task2;

/**
 * Created by Мария on 15.03.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        PropertiesReader propReader1 = new PropertiesReader();
        PropertiesReader propReader2 = new PropertiesReader();
        PropertiesReader propReader3 = new PropertiesReader();
        PropertiesReader propReader4 = new PropertiesReader();

        propReader1.getProperties("test_en_US", "en_US");
        propReader2.getProperties("test_en_US", "en_US");
        propReader3.getProperties("test_en_US", "en_US");
        propReader4.getProperties("test_en_US", "en_US");

        propReader1.start();
        propReader2.start();
        propReader3.start();
        propReader4.start();

        propReader1.join();
        propReader2.join();
        propReader3.join();
        propReader4.join();

        propReader1.showResult();
        propReader2.showResult();
        propReader3.showResult();
        propReader4.showResult();
        System.out.println("All threads completed reading");


    }
}
