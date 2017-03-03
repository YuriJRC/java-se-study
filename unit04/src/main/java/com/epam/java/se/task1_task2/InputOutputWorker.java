package com.epam.java.se.task1_task2;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Мария on 02.03.2017.
 */
public class InputOutputWorker {
    private static String KEYS_PATH = "keys.txt";
    private static String INPUT_FILE_PATH = "java_code.txt";
    private static String OUTPUT_FILE_PATH = "output.txt";
    private ArrayList<String> keysCollection = new ArrayList<>();
    private StringBuilder builder;
    private BufferedReader streamReader;

    private String line;


    public ArrayList<String> getArrayOfKeysFromFileWithByteReader() {
        try {
            streamReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(KEYS_PATH), "windows-1251"));
            while ((line = streamReader.readLine()) != null) {
                keysCollection.add(line);
            }
            streamReader.close();
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

    public String getFileWithJavaCodeToStringWithByteStream() {
        builder = new StringBuilder();
        try {
            streamReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(INPUT_FILE_PATH), "windows-1251"));
            while ((line = streamReader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            streamReader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return builder.toString();
    }

    public String getKeyWordsAndTheirCountFromFile(String readerType) {
        builder = new StringBuilder();
        if (readerType == null || readerType.equals("")
                || keysCollection == null) {
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
        return builder.append("Count: ").append(count).toString();
    }

    public void writeKeyWordsAndTheirCountToFileWithByteStream(String keywords) {
        if (keywords == null || keywords.equals("")) {
            throw new NullPointerException("Empty data");
        }
        try {
            FileOutputStream streamWriter = new FileOutputStream(OUTPUT_FILE_PATH);
            byte[] keywordsInBytes = keywords.getBytes();
            streamWriter.write(keywordsInBytes);
            streamWriter.flush();
            streamWriter.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

}
