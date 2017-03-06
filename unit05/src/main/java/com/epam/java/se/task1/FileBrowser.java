package com.epam.java.se.task1;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Мария on 06.03.2017.
 */
public class FileBrowser {
    private File file;
    private String path;


    public void showAbsolutePath(File file)throws FileNotFoundException{
        if (file.exists()){
            path = file.getAbsolutePath();
            System.out.println("Absolute pathname "+ path);
        }
        else throw new FileNotFoundException("File not found");
    }

    public void showDirectoryContent(){
    }


}
