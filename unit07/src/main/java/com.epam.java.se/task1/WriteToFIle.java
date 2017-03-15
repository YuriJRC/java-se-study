package com.epam.java.se.task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Мария on 15.03.2017.
 */
public class WriteToFIle {

    public void writeAccount (String filePath, Account account) {
        if (filePath == null || account == null) {
            throw new NullPointerException("Empty data");
        }
        try {
            ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(filePath));
            objectWriter.writeObject(account);
            objectWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
