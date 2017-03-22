package task02;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.MissingResourceException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Мария on 22.03.2017.
 */
public class PropertiesReaderToHashMapTest {
    private PropertiesReaderToHashMap readerToHashMap;

    @Before
    public void init() {
        readerToHashMap = new PropertiesReaderToHashMap();
    }

    @Test
    public void testThatWeCanCreateNewHashMap() {
        HashMap<String, String> emptyMap = readerToHashMap.getPropertiesToHashMap("", "");
        assertThat(emptyMap, is(notNullValue()));
    }

    @Test
    public void nullPointerExceptionCaughtTest() throws Exception {
        try {
            readerToHashMap.getPropertiesToHashMap(null, null);
            readerToHashMap.getValueByKey(null);
            readerToHashMap.showAllProperties();
        } catch (NullPointerException e) {
            assertEquals(e.getMessage(), "Empty data");
        }
    }

    @Test
    public void MissingResourceExceptionCaughtTest() throws Exception {
        try {
            readerToHashMap.getPropertiesToHashMap("d", "en_US");
        } catch (MissingResourceException e) {
            assertEquals(e.getMessage(), "Properties file not found");
        }
    }

    @Test
    public void MissingKeyTest() throws Exception {
        readerToHashMap.getPropertiesToHashMap("test_en_US", "en_US");

        String valueByKey = readerToHashMap.getValueByKey("888");

        assertThat(valueByKey, is("Key not found"));
    }

    @Test (expected = NullPointerException.class)
    public void testThatWeCannotAddNullAsKey() throws Exception {
        readerToHashMap.getPropertiesToHashMap("test_en_US_with_null_key", "en_US");
    }

    @Test
    public void testThatWeCanGetValueByKey() throws Exception {
        readerToHashMap.getPropertiesToHashMap("test_en_US", "en_US");

        assertThat(readerToHashMap.getValueByKey("2"), is("bbbbbb"));
    }

    @Test
    public void addKeyThatAlreadyExistsTest() throws Exception {
        HashMap<String, String> mapBeforeWeChangeFirstKey = readerToHashMap.getPropertiesToHashMap("test", "");

        assertThat(mapBeforeWeChangeFirstKey.get("1"), is("aaa"));

        HashMap<String, String> mapAfterWeChangeFirstKey = readerToHashMap.getPropertiesToHashMap("test", "test_ru");

        assertThat(mapAfterWeChangeFirstKey.get("1"), is("ÿÿÿÿ"));
    }

    @Test
    public void classLogicTest() throws Exception {
        readerToHashMap.getPropertiesToHashMap("test_en_US", "en_US");
        readerToHashMap.showAllProperties();

        System.out.println();
        System.out.println(readerToHashMap.getValueByKey("1"));
    }
}
