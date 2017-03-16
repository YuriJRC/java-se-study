package com.epam.java.se.task2;

/**
 * Created by Мария on 15.03.2017.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        PropertiesReader propReader1 = new PropertiesReader("test_en_US", "en_US");
        PropertiesReader propReader2 = new PropertiesReader("test_en_US", "en_US");
        PropertiesReader propReader3 = new PropertiesReader("test_en_US", "en_US");
        PropertiesReader propReader4 = new PropertiesReader("test_en_US", "en_US");

        propReader1.start();
        propReader2.start();
        propReader3.start();
        propReader4.start();

        Thread.sleep(1000);

        propReader1.join();
        propReader2.join();
        propReader3.join();
        propReader4.join();

        System.out.println("All threads completed reading");


    }
}
