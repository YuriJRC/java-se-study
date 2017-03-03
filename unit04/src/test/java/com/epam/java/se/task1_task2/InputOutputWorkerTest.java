package com.epam.java.se.task1_task2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Мария on 02.03.2017.
 */
public class InputOutputWorkerTest {
    @Test
            (expected = NullPointerException.class)
    public void nullPointerTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        worker.writeKeyWordsAndTheirCountToFileWithByteStream(null);

        worker.getKeyWordsAndTheirCountFromFile("");
    }

    @Test
    public void getArrayOfKeysFromFileWithByteReaderTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();
        String key = "private";
        String key2 = "hello";

        assertTrue(worker.getArrayOfKeysFromFileWithByteReader().contains(key));
        assertFalse(worker.getArrayOfKeysFromFileWithByteReader().contains(key2));
    }

    @Test
    public void getStringWithJavaCodeFromFileWithByteStreamTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        String word = "package";

        assertTrue(worker.getStringWithJavaCodeFromFileWithByteStream().length() > 0 &&
                worker.getStringWithJavaCodeFromFileWithByteStream().length() < 3000);
        assertFalse(worker.getStringWithJavaCodeFromFileWithByteStream().length() < 2000);
        assertTrue(worker.getStringWithJavaCodeFromFileWithByteStream().contains(word));

    }

    @Test
    public void getKeyWordsAndTheirCountFromFileTest() throws Exception {
        InputOutputWorker worker = new InputOutputWorker();

        String count = "16";
        String fake = "hello";

        worker.getArrayOfKeysFromFileWithByteReader();

        assertTrue(worker.getKeyWordsAndTheirCountFromFile
                (worker.getStringWithJavaCodeFromFileWithByteStream()).contains(count));
        assertFalse(worker.getKeyWordsAndTheirCountFromFile
                (worker.getStringWithJavaCodeFromFileWithByteStream()).contains(fake));
    }

}
