package com.epam.java.se.task1;

import java.io.*;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileWorker {
    private File file;
    private String path;


    public void showFilePath(File file) throws FileNotFoundException {
        try {
            if (file.exists()) {
                path = file.getAbsolutePath();
                System.out.println("Absolute pathname: " + path);
            } else throw new FileNotFoundException("File not found");
        } catch (NullPointerException e) {
            System.out.println("File not found");
        }
    }

    public void searchOnlyTXTFiles(File directory) {
        try {
            if (directory.isDirectory()) {
                FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
                String[] fileList = directory.list(filter);
                for (String s : fileList) {
                    System.out.println(s + " ");
                }
            } else System.out.println("Directory not found");
        } catch (NullPointerException e) {
            System.out.println("Directory not found");
        }
    }

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

