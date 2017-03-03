package com.epam.java.se.task3;

import java.io.*;

/**
 * Created by Мария on 03.03.2017.
 */
public class EncodingChanger {

    public String readFileInUTF_8(String inputFilePath) {
        StringBuilder  builder = new StringBuilder();
        String line;
        if (inputFilePath == null) {
            throw new NullPointerException("File not found");
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(inputFilePath), "UTF-8"));
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return builder.toString();
    }

    public void writeFileToUTF_16(String outputFilePath, String dataToWrite){
        if (outputFilePath == null || dataToWrite == null) {
            throw new NullPointerException("File not found");
        }
        try{
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputFilePath), "UTF-16"));
        writer.write(dataToWrite);
        writer.flush();
        writer.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }



}
