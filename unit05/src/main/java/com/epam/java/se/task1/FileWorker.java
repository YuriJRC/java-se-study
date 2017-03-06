package com.epam.java.se.task1;

import java.io.*;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileWorker {

    public void createNewFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else{
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println(("Wrong input data"));
        }
    }

    public void removeFile(){

    }

    public void writeToFile(File inputFile, String text){
        try {
            if (inputFile.exists()) {
                PrintWriter writer = new PrintWriter(new FileOutputStream(inputFile, true));
                writer.print(text);
                writer.flush();
                writer.close();
            }
            else System.out.println("File noy found");
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    public void readFromFile(){

    }

}
