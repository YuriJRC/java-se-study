package com.epam.java.se.task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Мария on 15.03.2017.
 */
public class WriteToFIle {
    private ArrayList <Account> accounts;

    public WriteToFIle (){
        accounts = new ArrayList<>();
    }

    public void writeAccounts (String filePath, Account... account) {
        if (filePath == null || account == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            for (Account a : account) {
                accounts.add(a);
            }
            ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(filePath));
            objectWriter.writeObject(accounts);
            objectWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
