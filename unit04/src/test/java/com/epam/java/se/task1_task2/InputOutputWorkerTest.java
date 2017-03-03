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
    public void getKeyWordsFromFileTest(){
        InputOutputWorker worker = new InputOutputWorker();
        String key = "private";
        String key2 = "hello";

        assertTrue(worker.getArrayOfKeysFromFileWithByteReader().contains(key));
        assertFalse(worker.getArrayOfKeysFromFileWithByteReader().contains(key2));
    }
}
