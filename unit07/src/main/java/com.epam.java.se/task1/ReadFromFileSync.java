package com.epam.java.se.task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by Мария on 16.03.2017.
 */
public class ReadFromFileSync extends Thread {
    private ArrayList<Account> accounts;
    private String filePath;
    private boolean run;

    public ReadFromFileSync(String filePath) {
        accounts = new ArrayList<>();
        this.filePath = filePath;
        run = true;
    }

    public void run() {
        try {
            while (run) {
                System.out.println(getName() + " is reading\n");
                getListOfAccounts();
                Thread.sleep(100);
                interrupt();
            }
        } catch (InterruptedException e) {
            showAccounts();
            stopThread();
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
            synchronized (accounts) {
                ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(filePath));
                accounts = (ArrayList<Account>) objectReader.readObject();
                objectReader.close();
            }
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
