package com.epam.java.se.task3;

import org.junit.Test;

/**
 * Created by Мария on 03.03.2017.
 */
public class EncodingChangerTest {
    private static String INPUT_FILE_PATH = "utf-8_input.txt";
    private static String OUTPUT_FILE_PATH = "utf-16_output.txt";

    @Test
            public void readerTest(){
        EncodingChanger encodingChanger = new EncodingChanger();
        String read = encodingChanger.readFileInUTF_8(INPUT_FILE_PATH);
        System.out.println(read);
    }
    @Test
    public void writerTest(){
        EncodingChanger encodingChanger = new EncodingChanger();
        String read = encodingChanger.readFileInUTF_8(INPUT_FILE_PATH);

        encodingChanger.writeFileToUTF_16(OUTPUT_FILE_PATH, read);
    }


}
