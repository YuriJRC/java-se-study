package com.epam.java.se.task1;

import java.io.File;
import java.nio.file.NotDirectoryException;

/**
 * Created by Мария on 06.03.2017.
 */
public class DirectoryBrowser {
    private File directory;

    public DirectoryBrowser() {
        directory = new File(System.getProperty("user.dir"));
    }

    public DirectoryBrowser(String path) {
        directory = new File(path);
    }

    public void showCurrentDirectory() {
        System.out.println("Current directory: " + directory);
    }

    public String getDirectoryToString() {
        return directory.toString();
    }

    public File getDirectory() {return directory;}

    public void changeDirectory(String path){
        try {
            File tmpDirectory = new File(path);
            if (tmpDirectory.isDirectory() && tmpDirectory.exists()) {
                directory = tmpDirectory;
                System.out.println(directory);
            } else throw new NotDirectoryException("Directory not found");
        } catch (NullPointerException | NotDirectoryException e) {
            System.out.println("Wrong path or directory");
        }
    }

    public void showDirectoryContent() {
        try {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    System.out.println(file.getName() + "  \t\tcatalogue");
                } else System.out.println(file.getName() + " \t\tfile");
            }
        } catch (NullPointerException e) {
            System.out.println("Directory not found");
        }
    }

    public void goUp() {
        try {
            File tmpDirectory = new File(directory.getParent());
            if (tmpDirectory.isDirectory()) {
                directory = tmpDirectory;
                System.out.println(directory);
            } else throw new NotDirectoryException("Directory not found");
        } catch (NullPointerException | NotDirectoryException e) {
            System.out.println("Root directory");
        }
    }

    public void goDown(String catalogue) {
        try {
            File tmpDirectory = new File(directory.getAbsolutePath() + "\\" + catalogue);
            if (tmpDirectory.isDirectory() && tmpDirectory.exists()) {
                directory = tmpDirectory;
                System.out.println(directory);
            } else throw new NotDirectoryException("Directory not found");
        } catch (NullPointerException | NotDirectoryException e) {
            System.out.println("Directory not found");
        }
    }

    public void createNewDirectory(String catalogue) {
        try {
            directory = new File(directory.getAbsolutePath() + "\\" + catalogue);
            if (!directory.exists() && directory.mkdir()) {
                System.out.println("New directory created");
            } else throw new NotDirectoryException("Wrong path");
        } catch (NullPointerException | NotDirectoryException e) {
            System.out.println("Wrong path or directory already exists");
        }
    }

    public void renameDirectory(String catalogue) {
        try {
            File tmpDirectory = new File(directory.getParent() + "\\" + catalogue);
            boolean isRenamed = directory.renameTo(tmpDirectory);
            if (isRenamed || tmpDirectory.exists()) {
                directory = tmpDirectory;
                System.out.println("Directory renamed");
            } else throw new NotDirectoryException("Wrong path or directory");
        } catch (NullPointerException | NotDirectoryException e) {
            System.out.println("Wrong path or directory");
        }
    }
}
