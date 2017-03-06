package com.epam.java.se.task1;

import java.io.File;
import java.io.IOException;

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
    public void writeToFile(){

    }
    public void readFromFile(){

    }

}
