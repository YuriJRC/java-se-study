package com.epam.java.se.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.nio.file.NotDirectoryException;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileBrowser {
    private String path;


    public void showAbsolutePath(File file) throws FileNotFoundException, NullPointerException {
        try {
            if (file.exists()) {
                path = file.getAbsolutePath();
                System.out.println("Absolute pathname " + path);
            } else throw new FileNotFoundException("File not found");
        } catch (NullPointerException e){
            System.out.println("File not found");
        }
    }

    public void showDirectoryContent(File directory) throws NullPointerException{
        try {
            if (directory.isDirectory()) {
                for (File file : directory.listFiles()) {
                    if (file.isDirectory()) {
                        System.out.println(file.getName() + "  \tcatalogue");
                    } else System.out.println(file.getName() + "\tfile");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Directory not found");
        }
    }

    public void searchOnlyTXTFiles(File directory) throws NullPointerException{
        try {
            if (directory.isDirectory()) {
                FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
                String[] fileList = directory.list(filter);
                for (String s : fileList) {
                    System.out.println(s + " ");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Directory not found");
        }
    }

    public void goUp(File file) throws FileNotFoundException, NullPointerException {
        try {
            if (file.exists()) {
                path = file.getParent();
                System.out.println(path);
            } else throw new FileNotFoundException("File not found");
        } catch (NullPointerException e){
            System.out.println("File not found");
        }
    }

    public void goDown(File directory, String catalogue) throws NullPointerException{
        try {
            if (directory.isDirectory()) {
                path = directory.getAbsolutePath() + "\\" + catalogue;
                System.out.println(path);
            } else System.out.println("Directory not found");
        } catch (NullPointerException e) {
            System.out.println("Directory not found");
        }
    }

    public void createNewDirectory(File directory) throws NullPointerException{
        try {
            if (directory.mkdir()) {
                System.out.println("New directory created");
            } else System.out.println("Directory already exists");
        } catch (NullPointerException e){
            System.out.println("Directory not found");
        }
    }

    public void renameDirectory(File directory, File newDirectory) throws NotDirectoryException, NullPointerException{
        try {
            boolean isRenamed = directory.renameTo(newDirectory);
            if (isRenamed || newDirectory.exists()) {
                System.out.println("Directory renamed");
            } else throw new NotDirectoryException("Wrong path or directory");
        } catch (NullPointerException e){
            System.out.println("Empty data");
        }
    }
}
