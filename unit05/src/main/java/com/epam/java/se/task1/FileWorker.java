package com.epam.java.se.task1;

import java.io.*;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileWorker {

    public void createNewFile(File file) throws IOException {
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else System.out.println("File already exists");
        } catch (IOException e) {
            System.out.println(("Wrong input data"));
        }
    }

    public void deleteFile(File file) throws IOException {
        if (file.delete()) {
            System.out.println("File deleted");
        } else throw new IOException("File not found");
    }

    public void writeToFile(File inputFile, String text) throws FileNotFoundException {
        try {
            if (inputFile.exists()) {
                PrintWriter writer = new PrintWriter(new FileOutputStream(inputFile, true));
                writer.print(text);
                writer.flush();
                writer.close();
            } else System.out.println("File not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public void readFromFile() {

    }

}
