package com.epam.java.se.task3;

import com.epam.java.se.task1_task2.InputOutputWorker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.File;

/**
 * Created by Мария on 03.03.2017.
 */
public class EncodingChangerTest {
    private EncodingChanger encodingChanger;
    private static String INPUT_FILE_PATH = "utf-8_input.txt";
    private static String OUTPUT_FILE_PATH = "utf-16_output.txt";

    @Before
    public void init() throws Exception {
        encodingChanger = new EncodingChanger();
    }

    @Test
            (expected = NullPointerException.class)
    public void nullPointerTest() throws Exception {
        encodingChanger.writeFileToUTF_16(null, null);
        encodingChanger.readFileInUTF_8(null);
    }


    @Test
    public void readerTest() {
        String read = encodingChanger.readFileInUTF_8(INPUT_FILE_PATH);
        System.out.println(read);

        assertTrue(read.contains("utf-8"));
        assertTrue(read.contains("utf-16"));


    }

    @Test
    public void writerTest() {
        File file = new File(OUTPUT_FILE_PATH);

        String read = encodingChanger.readFileInUTF_8(INPUT_FILE_PATH);

        encodingChanger.writeFileToUTF_16(OUTPUT_FILE_PATH, read);

        assertTrue(file.exists());
        assertTrue(file.length() > 100);
    }


}
