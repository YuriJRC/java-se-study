package com.epam.java.se.task1_task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Мария on 02.03.2017.
 */
public class ByteStreamWorker {
    private static String KEYS_PATH = "keys.txt";
    private static String FILE_PATH = "java_code.txt";
    private ArrayList<String> keysCollection = new ArrayList<>();
    private StringBuilder builder;
    private BufferedReader reader;
    private String line;


    public ArrayList<String> getArrayOfKeysFromFileWithByteReader() {
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(KEYS_PATH), "windows-1251"));
            while ((line = reader.readLine()) != null) {
                keysCollection.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return keysCollection;
    }

    public void printKeys() {
        for (int i = 0; i < keysCollection.size(); i++) {
            System.out.println(keysCollection.get(i));
        }
    }

    public String getFileWithJavaCodeToStringWithByteReader() {
        builder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(FILE_PATH), "windows-1251"));
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return builder.toString();
    }

    public String getKeyWordsAndTheirCountFromFile(String readerType) {
        builder = new StringBuilder();
        if (readerType == null || readerType.equals("")
                || keysCollection==null) {
            throw new NullPointerException("Empty data");
        }
        int count = 0;
        builder.append("Keywords: ").append("\n");
        for (int i = 0; i < keysCollection.size(); i++) {
            if (readerType.contains(keysCollection.get(i))) {
                count++;
                builder.append(keysCollection.get(i)).append("\n");
            }
        }
        return builder.append("Count: " + count).toString();
    }
//
//    public void writeKeysToFile() {
//
//    }
}
