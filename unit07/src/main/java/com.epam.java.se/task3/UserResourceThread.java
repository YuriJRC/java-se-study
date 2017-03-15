package com.epam.java.se.task3;

/**
 * Created by Мария on 15.03.2017.
 */
public class UserResourceThread {
    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();

        IntegerSetterGetter t1 = new IntegerSetterGetter("1", res);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", res);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", res);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", res);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        Thread.sleep(100);

        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("main");
    }
}
