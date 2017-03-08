package com.epam.java.se.task1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Мария on 08.03.2017.
 */
public class Main {
    public static void showCommands(){
        System.out.println("Select:\ncur - show current directory\n" +
        "up - show parent directory\ndown - input child directory\n" +
        "con - show current content of directory\nmk - make new directory" +
        "(input name)\nrnm - rename current directory");
    }

    public static void main(String[] args) throws IOException {
        DirectoryBrowser directoryBrowser = new DirectoryBrowser();

        FileWorker fileWorker = new FileWorker();

        Scanner scanner = new Scanner(System.in);

        Main.showCommands();
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "cur":
                    directoryBrowser.showCurrentDirectory();
                    break;
                case "up":
                    directoryBrowser.goUp();
                    break;
                case "down":
                    directoryBrowser.showCurrentDirectory();
                    command = scanner.nextLine();
                    directoryBrowser.goDown(command);
                    break;
                case "con":
                    directoryBrowser.showDirectoryContent();
                    break;
                case "mk":
                    directoryBrowser.showCurrentDirectory();
                    command = scanner.nextLine();
                    directoryBrowser.createNewDirectory(command);
                    break;
                case "rnm":
                    directoryBrowser.showCurrentDirectory();
                    command = scanner.nextLine();
                    directoryBrowser.renameDirectory(command);
                    break;
            }
        }
    }
}
