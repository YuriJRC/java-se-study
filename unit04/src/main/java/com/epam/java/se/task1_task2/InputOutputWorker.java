package com.epam.java.se.task1_task2;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Мария on 02.03.2017.
 */
public class InputOutputWorker {
    private StringBuilder builder;
    private BufferedReader streamReader;
    private String line;

    public ArrayList<String> getArrayOfKeysFromFileWithByteReader(String fileWithKeysPath) {
        ArrayList<String> keysCollection = new ArrayList<>();
        try {
            streamReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileWithKeysPath), "windows-1251"));
            while ((line = streamReader.readLine()) != null) {
                keysCollection.add(line);
            }
            streamReader.close();
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

    public String getStringWithJavaCodeFromFileWithByteStream(String inputFilePath) {
        builder = new StringBuilder();
        try {
            streamReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(inputFilePath), "windows-1251"));
            while ((line = streamReader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            streamReader.close();
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

    public void writeKeyWordsAndTheirCountToFileWithByteStream(String outputFilePath, String keywords) {
        if (keywords == null || keywords.equals("")) {
            throw new NullPointerException("Empty data");
        }
        try {
            FileOutputStream streamWriter = new FileOutputStream(outputFilePath);
            byte[] keywordsInBytes = keywords.getBytes();
            streamWriter.write(keywordsInBytes);
            streamWriter.flush();
            streamWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

}
