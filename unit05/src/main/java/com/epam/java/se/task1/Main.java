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
                "new - create new file in current directory\ndel - delete file in current directory\n" +
                "wrt - write to filw in current directory\nread - read from file in current directory\n" +
                "quit - exit program\n");
    }

    public static void main(String[] args) throws IOException {
        DirectoryBrowser directoryBrowser = new DirectoryBrowser();

        FileWorker fileWorker = new FileWorker();

        Scanner scanner = new Scanner(System.in);

        showCommands();

        while (true) {
            System.out.println("Input command");
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
                    break;
                case "new":
                    System.out.println("Input new file name");
                    command = scanner.nextLine();
                    fileWorker.createNewFile(directoryBrowser.getDirectory(), command);
                    break;
                case "del":
                    System.out.println("Input file name to delete");
                    command = scanner.nextLine();
                    fileWorker.deleteFile(directoryBrowser.getDirectory(), command);
                    break;
                case "wrt":
                    System.out.println("Input file name to write to");
                    command = scanner.nextLine();
                    System.out.println("Append: true or false");
                    String append = scanner.nextLine();
                    System.out.println("Input text");
                    String text = scanner.nextLine();
                    fileWorker.writeToFile(directoryBrowser.getDirectory(), command, append, text);
                    break;
                case "read":
                    System.out.println("Input file name to read");
                    command = scanner.nextLine();
                    fileWorker.readFromFile(directoryBrowser.getDirectory(), command);
                    break;
                case "quit":
                    System.exit(0);
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }
    }
}
