package com.epam.java.se.task1_task2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Мария on 02.03.2017.
 */
public class InputOutputWorker {
    private StringBuilder builder;
    private ArrayList<String> keysCollection;
    private BufferedReader charReader;
    private FileInputStream byteReader;
    private String line;
    private int read;

    public ArrayList<String> getArrayOfKeysFromFileWithCharReader(String fileWithKeysPath) {
        if (fileWithKeysPath==null){
            throw new NullPointerException("File not found");
        }
        keysCollection = new ArrayList<>();
        try {
            charReader = new BufferedReader(new FileReader(fileWithKeysPath));
            while ((line = charReader.readLine()) != null) {
                keysCollection.add(line);
            }
            charReader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return keysCollection;
    }
    public ArrayList<String> getArrayOfKeysFromFileWithByteReader (String fileWithKeysPath) {
        if (fileWithKeysPath==null){
            throw new NullPointerException("File not found");
        }
        keysCollection = new ArrayList<>();
        builder = new StringBuilder();
        try {
            byteReader = new FileInputStream(fileWithKeysPath);
            while ((read = byteReader.read()) != -1) {
                builder.append((char) read);
            }
            String[] separator = builder.toString().split("[\\s]+");
            Collections.addAll(keysCollection, separator);

            byteReader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return keysCollection;
    }

    public void printKeys(ArrayList<String> keys) {
        if (keys == null){
            throw new NullPointerException("Empty data");
        }
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i));
        }
    }

    public String getStringWithJavaCodeFromFileWithCharReader(String inputFilePath) {
        if (inputFilePath==null){
            throw new NullPointerException("File not found");
        }
        builder = new StringBuilder();
        try {
            charReader = new BufferedReader(new FileReader(inputFilePath));
            while ((line = charReader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            charReader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return builder.toString();
    }
    public String getStringWithJavaCodeFromFileWithByteReader(String inputFilePath) {
        if (inputFilePath==null){
            throw new NullPointerException("File not found");
        }
        builder = new StringBuilder();
        try {
            byteReader = new FileInputStream(inputFilePath);
            while ((read = byteReader.read()) != -1) {
                builder.append((char)read);
            }
            byteReader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return builder.toString();
    }

    public String getKeyWordsAndTheirCountFromFile(ArrayList<String> keys, String stringWithJavaCode) {
        builder = new StringBuilder();
        if (stringWithJavaCode == null || stringWithJavaCode.equals("")
                || keys == null) {
            throw new NullPointerException("Empty data");
        }
        int count = 0;
        builder.append("Keywords: ").append("\n");
        for (int i = 0; i < keys.size(); i++) {
            if (stringWithJavaCode.contains(keys.get(i))) {
                count++;
                builder.append(keys.get(i)).append("\n");
            }
        }
        return builder.append("Count: ").append(count).toString();
    }

    public void writeKeyWordsAndTheirCountToFileWithByteOutputStream(String outputFilePath, String keywords) {
        if (keywords == null || keywords.equals("")) {
            throw new NullPointerException("Empty data");
        }
        try {
            FileOutputStream byteWriter = new FileOutputStream(outputFilePath);
            byte[] keywordsInBytes = keywords.getBytes();
            byteWriter.write(keywordsInBytes);
            byteWriter.flush();
            byteWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

}
