package com.epam.java.se.task1_task2;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Мария on 02.03.2017.
 */
public class InputOutputWorkerTest {
    private static String KEYS_PATH = "keys.txt";
    private static String INPUT_FILE_PATH = "java_code.txt";
    private static String OUTPUT_FILE_PATH = "output.txt";

    @Test
            (expected = NullPointerException.class)
    public void nullPointerTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        worker.printKeys(null);

        worker.getArrayOfKeysFromFileWithCharReader(null);

        worker.getArrayOfKeysFromFileWithByteReader(null);

        worker.writeKeyWordsAndTheirCountToFileWithByteOutputStream(null, "");

        worker.getKeyWordsAndTheirCountFromFile(null, "");
    }

    @Test
    public void getArrayOfKeysFromFileWithCharReaderTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();
        String key = "private";
        String key2 = "hello";

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithCharReader(KEYS_PATH);

        assertTrue(keysList.contains(key));
        assertFalse(keysList.contains(key2));

        worker.printKeys(keysList);
    }

    @Test
    public void getArrayOfKeysFromFileWithByteReaderTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();
        String key = "int";
        String key2 = "hello";

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithByteReader(KEYS_PATH);

        assertTrue(keysList.contains(key));
        assertFalse(keysList.contains(key2));

        worker.printKeys(keysList);
    }

    @Test
    public void getStringWithJavaCodeFromFileWithCharReaderTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        String word = "package";
        String javaCode = worker.getStringWithJavaCodeFromFileWithCharReader(INPUT_FILE_PATH);

        System.out.println(javaCode);

        assertTrue(javaCode.length() > 0 && javaCode.length() < 3000);
        assertFalse(javaCode.length() < 2000);
        assertTrue(javaCode.contains(word));
    }

    @Test
    public void getStringWithJavaCodeFromFileWithByteReaderTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        String word = "final";
        String javaCode = worker.getStringWithJavaCodeFromFileWithByteReader(INPUT_FILE_PATH);

        System.out.println(javaCode);

        assertTrue(javaCode.length() > 0 && javaCode.length() < 3000);
        assertFalse(javaCode.length() < 2000);
        assertTrue(javaCode.contains(word));

    }

    @Test
    public void getKeyWordsAndTheirCountFromFileWithCharReaderTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        String count = "16";
        String fake = "hello";

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithCharReader(KEYS_PATH);
        String javaCode = worker.getStringWithJavaCodeFromFileWithCharReader(INPUT_FILE_PATH);
        String getKeyWords = worker.getKeyWordsAndTheirCountFromFile(keysList, javaCode);

        System.out.println(getKeyWords);

        assertTrue(getKeyWords.contains(count));
        assertFalse(getKeyWords.contains(fake));
    }

    @Test
    public void getKeyWordsAndTheirCountFromFileWithByteReaderTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        String count = "16";
        String key = "void";
        String fake = "hello";

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithByteReader(KEYS_PATH);
        String javaCode = worker.getStringWithJavaCodeFromFileWithByteReader(INPUT_FILE_PATH);
        String getKeyWords = worker.getKeyWordsAndTheirCountFromFile(keysList, javaCode);

        System.out.println(getKeyWords);

        assertTrue(getKeyWords.contains(count));
        assertTrue(getKeyWords.contains(key));
        assertFalse(getKeyWords.contains(fake));
    }

    @Test
    public void writeKeyWordsAndTheirCountToFileWithByteStreamTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();
        File file = new File(OUTPUT_FILE_PATH);

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithCharReader(KEYS_PATH);
        String javaCode = worker.getStringWithJavaCodeFromFileWithCharReader(INPUT_FILE_PATH);
        String getKeyWords = worker.getKeyWordsAndTheirCountFromFile(keysList, javaCode);

        worker.writeKeyWordsAndTheirCountToFileWithByteOutputStream(OUTPUT_FILE_PATH, getKeyWords);

        assertTrue(file.exists());
        assertTrue(file.length() > 0);

    }

}
