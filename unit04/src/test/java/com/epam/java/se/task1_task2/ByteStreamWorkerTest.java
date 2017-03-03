package com.epam.java.se.task1_task2;

import org.junit.Test;

/**
 * Created by Мария on 02.03.2017.
 */
public class ByteStreamWorkerTest {
    @Test
    public void arrayOfKeysTest() throws Exception{
        ByteStreamWorker worker = new ByteStreamWorker();

        worker.getArrayOfKeysFromFileWithByteReader();
//        worker.printKeys();
//        worker.getFileWithJavaCodeToStringWithByteReader();

        System.out.println(worker.getKeyWordsAndTheirCountFromFile(worker.getFileWithJavaCodeToStringWithByteReader()));

    }
}
