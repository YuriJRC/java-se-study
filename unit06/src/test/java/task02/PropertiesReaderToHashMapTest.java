package task02;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Мария on 22.03.2017.
 */
public class PropertiesReaderToHashMapTest {
    PropertiesReaderToHashMap readerToHashMap;

    @Before
    public void init(){
        readerToHashMap = new PropertiesReaderToHashMap();
    }


    @Test
    public void testThatWeCanCreateNewHashMap() {
        HashMap <String, String> emptyMap = readerToHashMap.getPropertiesToHashMap("", "");
        assertThat(emptyMap, is(notNullValue()));
    }

    @Test
    public void nullPointerExceptionCaughtTest() throws Exception {

    }

    @Test
    public void MissingResourceExceptionCaughtTest() throws Exception {

    }

    @Test
    public void MissingKeyTest() throws Exception {

    }

    @Test
    public void testThatWeCannotAddNullAsKey(){

    }

    @Test
    public void testThatWeCanGetKeyByValue(){

    }

    @Test
    public void addKeyThatAlreadyExistsTest(){
        HashMap <String, String> mapBeforeWeChangeFirstKey = readerToHashMap.getPropertiesToHashMap("test", "");

        assertThat(mapBeforeWeChangeFirstKey.get("1"), is("aaa"));

        HashMap <String, String> mapAfterWeChangeFirstKey =readerToHashMap.getPropertiesToHashMap("test", "test_ru");

        assertThat(mapAfterWeChangeFirstKey.get("1"), is("ÿÿÿÿ"));


    }

    @Test
    public void classLogicTest(){
        readerToHashMap.getPropertiesToHashMap("test_en_US", "en_US");
        readerToHashMap.showAllProperties();

        System.out.println();
        System.out.println(readerToHashMap.getValueByKey("1"));
    }
}
