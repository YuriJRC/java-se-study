package com.epam.java.se.task1;

import java.io.*;
import java.nio.file.NotDirectoryException;
import java.util.InputMismatchException;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileWorker {
//    private File file;


    public void showFilePath(File directory, String filename) throws FileNotFoundException {
        try {
            File newDirectory = new File(directory.getAbsolutePath() + "\\" + filename);
            if (newDirectory.exists() && !newDirectory.isDirectory()) {
                System.out.println("Absolute pathname: " + newDirectory.getAbsolutePath());
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
                if (fileList.length == 0) {
                    throw new FileNotFoundException(".txt files not found");
                }
                for (String s : fileList) {
                    System.out.println(s + " ");
                }
            } else throw new NotDirectoryException("Directory not found");
        } catch (NullPointerException | NotDirectoryException | FileNotFoundException e) {
            System.out.println("Directory or files not found");
        }
    }

    public void createNewFile(File directory, String filename) throws IOException {
        try {
            File newFile = new File(directory.getAbsolutePath() + "\\" + filename);
            if (newFile.createNewFile()) {
                System.out.println("File created");
            } else System.out.println("File already exists");
        } catch (NullPointerException | IOException e) {
            System.out.println(("Wrong input data"));
        }
    }

    public void deleteFile(File directory, String filename) {
        try {
            File newFile = new File(directory.getAbsolutePath() + "\\" + filename);
            if (newFile.isFile() && newFile.delete()) {
                System.out.println("File deleted");
            } else System.out.println("File not found");
        } catch (NullPointerException e) {
            System.out.println(("File not found"));
        }
    }

    public void writeToFile(File directory, String filename, String append, String text) throws FileNotFoundException, InputMismatchException {
        try {
            File newFile = new File(directory.getAbsolutePath() + "\\" + filename);
            if (newFile.exists()) {
                PrintWriter writer = new PrintWriter(new FileOutputStream(newFile, Boolean.valueOf(append)));
                writer.print(text);
                writer.flush();
                writer.close();
                System.out.println("Written successfully");
            } else System.out.println("File not found or wrong data");
        } catch (FileNotFoundException | NullPointerException | InputMismatchException e) {
            System.out.println("File not found or wrong data");
        }
    }

    public void readFromFile(File directory, String filename) throws IOException {
        String line;
        try {
            File newFile = new File(directory.getAbsolutePath() + "\\" + filename);
            if (newFile.exists()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        new FileInputStream(newFile), "windows-1251"));
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else System.out.println("File not found");
        } catch (IOException | NullPointerException e) {
            System.out.println("File not found");
        }
    }

}

