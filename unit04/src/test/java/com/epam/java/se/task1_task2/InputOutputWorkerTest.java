package com.epam.java.se.task1_task2;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Мария on 02.03.2017.
 */
public class InputOutputWorkerTest {
    private InputOutputWorker worker;
    private static String KEYS_PATH = "keys.txt";
    private static String INPUT_FILE_PATH = "java_code.txt";
    private static String OUTPUT_FILE_PATH = "output.txt";

    @Before
    public void init()throws Exception {
        worker = new InputOutputWorker();
    }

    @Test
            (expected = NullPointerException.class)
    public void nullPointerTest() throws Exception {
        worker.printKeys(null);

        worker.getArrayOfKeysFromFileWithCharReader(null);

        worker.getArrayOfKeysFromFileWithByteReader(null);

        worker.writeKeyWordsAndTheirCountToFileWithByteWriter(null, "");

        worker.getKeyWordsAndTheirCountFromFile(null, "");
    }

    @Test
    public void getArrayOfKeysFromFileWithCharReaderTest() throws Exception {
        String key = "private";
        String key2 = "hello";

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithCharReader(KEYS_PATH);

        assertTrue(keysList.contains(key));
        assertFalse(keysList.contains(key2));

        worker.printKeys(keysList);
    }

    @Test
    public void getArrayOfKeysFromFileWithByteReaderTest() throws Exception {
        String key = "int";
        String key2 = "hello";

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithByteReader(KEYS_PATH);

        assertTrue(keysList.contains(key));
        assertFalse(keysList.contains(key2));

        worker.printKeys(keysList);
    }

    @Test
    public void getStringWithJavaCodeFromFileWithCharReaderTest() throws Exception {
        String word = "package";
        String javaCode = worker.getStringWithJavaCodeFromFileWithCharReader(INPUT_FILE_PATH);

        System.out.println(javaCode);

        assertTrue(javaCode.length() > 0 && javaCode.length() < 3000);
        assertFalse(javaCode.length() < 2000);
        assertTrue(javaCode.contains(word));
    }

    @Test
    public void getStringWithJavaCodeFromFileWithByteReaderTest() throws Exception {
        String word = "final";
        String javaCode = worker.getStringWithJavaCodeFromFileWithByteReader(INPUT_FILE_PATH);

        System.out.println(javaCode);

        assertTrue(javaCode.length() > 0 && javaCode.length() < 3000);
        assertFalse(javaCode.length() < 2000);
        assertTrue(javaCode.contains(word));

    }

    @Test
    public void getKeyWordsAndTheirCountFromFileWithCharReaderTest() throws Exception {
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
    public void writeKeyWordsAndTheirCountToFileWithCharWriterTest() throws Exception {
        File file = new File(OUTPUT_FILE_PATH);

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithCharReader(KEYS_PATH);
        String javaCode = worker.getStringWithJavaCodeFromFileWithCharReader(INPUT_FILE_PATH);
        String getKeyWords = worker.getKeyWordsAndTheirCountFromFile(keysList, javaCode);

        worker.writeKeyWordsAndTheirCountToFileWithCharWriter(OUTPUT_FILE_PATH, getKeyWords);

        assertTrue(file.exists());
        assertTrue(file.length() > 0);

    }


    @Test
    public void writeKeyWordsAndTheirCountToFileWithByteWriterTest() throws Exception {
        File file = new File(OUTPUT_FILE_PATH);

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithByteReader(KEYS_PATH);
        String javaCode = worker.getStringWithJavaCodeFromFileWithByteReader(INPUT_FILE_PATH);
        String getKeyWords = worker.getKeyWordsAndTheirCountFromFile(keysList, javaCode);

        worker.writeKeyWordsAndTheirCountToFileWithByteWriter(OUTPUT_FILE_PATH, getKeyWords);

        assertTrue(file.exists());
        assertTrue(file.length() > 100);

    }

}
