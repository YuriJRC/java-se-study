package com.epam.java.se.task1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by Мария on 15.03.2017.
 */
public class ReadFromFile {
    private ArrayList <Account> accounts = new ArrayList<>();


    public ArrayList<Account> getListOfAccounts (String filePath) {
        if (filePath == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            ObjectInputStream objectReader = new ObjectInputStream(new FileInputStream(filePath));
            accounts = (ArrayList <Account>) objectReader.readObject();
            objectReader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        return accounts;
    }
    public void showAccounts(){
        if (accounts==null){
            throw new NullPointerException("empty dara");
        }
        for (int i=0; i<accounts.size(); i++){
            System.out.println(accounts.get(i));
        }

    }
}
