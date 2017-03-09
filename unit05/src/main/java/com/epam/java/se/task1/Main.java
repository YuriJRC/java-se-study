package com.epam.java.se.task1;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Мария on 08.03.2017.
 */
public class Main {
    public static void showCommands() {
        System.out.println("Select:\ncur - show current directory\n" +
                "up - show parent directory\ndown - show child directory\n" +
                "con - show content of current directory\nmk - make new directory\n" +
                "rnm - rename current directory\ncng - change current directory\n" +
                "pth - show file path in current directory\ntxt - show only txt files in current directory\n" +
                "new - create new file in current directory\ndel - delete file in current directory");
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
                case "cng":
                    System.out.println("Input new current directory name");
                    command = scanner.nextLine();
                    directoryBrowser.changeDirectory(command);
                    break;
                case "up":
                    directoryBrowser.goUp();
                    break;
                case "down":
                    System.out.println("Input child's directory name");
                    command = scanner.nextLine();
                    directoryBrowser.goDown(command);
                    break;
                case "con":
                    directoryBrowser.showDirectoryContent();
                    break;
                case "mk":
                    System.out.println("Input new directory name");
                    command = scanner.nextLine();
                    directoryBrowser.createNewDirectory(command);
                    break;
                case "rnm":
                    System.out.println("Input new directory name");
                    command = scanner.nextLine();
                    directoryBrowser.renameDirectory(command);
                    break;
                case "pth":
                    System.out.println("Input file name in current directory");
                    command = scanner.nextLine();
                    fileWorker.showFilePath(directoryBrowser.getDirectory(), command);
                    break;
                case "txt":
                    fileWorker.searchOnlyTXTFiles(directoryBrowser.getDirectory());
                case "new":
                    System.out.println("Input new file name");
                    command = scanner.nextLine();
                    fileWorker.createNewFile(directoryBrowser.getDirectory(), command);
                case "del":
                    System.out.println("Input file name to delete");
                    command = scanner.nextLine();
                    fileWorker.deleteFile(directoryBrowser.getDirectory(), command);
            }
        }
    }
}
