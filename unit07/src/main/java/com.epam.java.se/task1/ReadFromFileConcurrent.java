package com.epam.java.se.task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Мария on 15.03.2017.
 */
public class ReadFromFileConcurrent extends Thread {
    private ArrayList<Account> accounts = new ArrayList<>();
    private String filePath;
    private boolean run;
    private static Lock lock = new ReentrantLock();

    public ReadFromFileConcurrent(String filePath) {
        this.filePath = filePath;
        run = true;
    }

    public void run() {
        while (run) {
            System.out.println(getName() + "is reading\n");
            lock.lock();
            getListOfAccounts();
            showAccounts();
            stopThread();
            lock.unlock();
        }
    }

    public void stopThread() {
        run = false;
        System.out.println(getName() + "completed reading\n");
    }

    public ArrayList<Account> getListOfAccounts() {
        if (filePath == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(filePath));
            accounts = (ArrayList<Account>) objectReader.readObject();
            objectReader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        return accounts;
    }

    public void showAccounts() {
        if (accounts == null) {
            throw new NullPointerException("empty dara");
        }
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
    }
}
