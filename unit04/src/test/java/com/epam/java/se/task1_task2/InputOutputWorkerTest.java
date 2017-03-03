package com.epam.java.se.task1_task2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
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

        worker.writeKeyWordsAndTheirCountToFileWithByteStream(null, "");

        worker.getKeyWordsAndTheirCountFromFile(null, "");
    }

    @Test
    public void getArrayOfKeysFromFileWithByteReaderTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();
        String key = "private";
        String key2 = "hello";

        ArrayList<String> keysList = worker.getArrayOfKeysFromFileWithByteReader(KEYS_PATH);

        assertTrue(keysList.contains(key));
        assertFalse(keysList.contains(key2));

        worker.printKeys(keysList);
    }

    @Test
    public void getStringWithJavaCodeFromFileWithByteStreamTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        String word = "package";
        String javaCode = worker.getStringWithJavaCodeFromFileWithByteStream(INPUT_FILE_PATH);

        assertTrue(javaCode.length() > 0 && javaCode.length() < 3000);
        assertFalse(javaCode.length() < 2000);
        assertTrue(javaCode.contains(word));

    }

    @Test
    public void getKeyWordsAndTheirCountFromFileTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        String count = "16";
        String fake = "hello";

        ArrayList<String> keysList =  worker.getArrayOfKeysFromFileWithByteReader(KEYS_PATH);
        String javaCode = worker.getStringWithJavaCodeFromFileWithByteStream(INPUT_FILE_PATH);
        String getKeyWords = worker.getKeyWordsAndTheirCountFromFile(keysList, javaCode);

        assertTrue(getKeyWords.contains(count));
        assertFalse(getKeyWords.contains(fake));
    }

    @Test
    public void writeKeyWordsAndTheirCountToFileWithByteStreamTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();
        File file = new File(OUTPUT_FILE_PATH);

        ArrayList<String> keysList =  worker.getArrayOfKeysFromFileWithByteReader(KEYS_PATH);
        String javaCode = worker.getStringWithJavaCodeFromFileWithByteStream(INPUT_FILE_PATH);
        String getKeyWords = worker.getKeyWordsAndTheirCountFromFile(keysList, javaCode);

        worker.writeKeyWordsAndTheirCountToFileWithByteStream(OUTPUT_FILE_PATH, getKeyWords);

        assertTrue(file.exists());
        assertTrue(file.length()>0);

    }

}
