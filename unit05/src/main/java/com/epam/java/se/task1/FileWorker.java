package com.epam.java.se.task1;

import java.io.*;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileWorker {

    public void createNewFile(File file) throws IOException{
        try {
            if (file.createNewFile()) {
                System.out.println("File created");
            } else System.out.println("File already exists");
        } catch (NullPointerException e) {
            System.out.println(("Wrong input data"));
        } catch (IOException e) {
            System.out.println(("Wrong input data"));
        }
    }

    public void deleteFile(File file) {
        try {
            if (file.delete()) {
                System.out.println("File deleted");
            } else System.out.println("File not found");
        } catch (NullPointerException e) {
            System.out.println(("File not found"));
        }
    }

    public void writeToFile(File outputFile, String text) throws FileNotFoundException{
        try {
            if (outputFile.exists()) {
                PrintWriter writer = new PrintWriter(new FileOutputStream(outputFile, true));
                writer.print(text);
                writer.flush();
                writer.close();
                System.out.println("Written successfully");
            } else System.out.println("File not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }catch (NullPointerException e) {
            System.out.println("File not found");
        }
    }

    public void readFromFile(File inputFile) throws IOException{
        String line;
        try {
            if (inputFile.exists()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(inputFile), "windows-1251"));
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (NullPointerException e) {
            System.out.println("File not found");
        }
    }

}

