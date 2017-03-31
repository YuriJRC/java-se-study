package com.epam.java.se;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

/**
 * Created by Мария on 25.03.2017.
 */

@FixMethodOrder
public class CustomHashMapTest {

    private Map<Integer, String> m;
    private Map<Object, String> m2;

    @Before
    public void init() {
        m = new CustomHashMap<>();
        m2 = new CustomHashMap<>();
    }

    @Test
    public void testThatWeCanCreate() {
        assertThat(m, is(notNullValue()));

    }

    @Test
    public void testThatNewMapIsEmpty() {
        assertThat(m.isEmpty(), is(true));
    }

    @Test
    public void testThatIfWeAddDataMapIsNotEmpty() {
        m.put(new Integer(3), "abc");
        assertThat(m.isEmpty(), is(false));
    }

    @Test
    public void testThatOnNewMapContainKeyMethodReturnFalseForAnyObject() {
        assertThat(m.containsKey(new Integer(1)), is(false));
    }

    @Test
    public void testThatWeCanPutKeyValuePairAndCanCheckIt() {
        m.put(new Integer(3), "abc");
        assertThat(m.containsKey(3), is(true));
    }

    @Test
    public void testThatWeCanPutMoreThanOneKeyValuePairAndCanCheckIt() {
        m.put(new Integer(3), "abc");
        m.put(new Integer(5), "abc");
        assertThat(m.containsKey(3), is(true));
        assertThat(m.containsKey(5), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void testThatMapCantContainNullKey() {
        assertThat(m.containsKey(null), is(false));
    }

    @Test
    public void testThatIfThereIsNoKeyReturnFalse() {
        m.put(new Integer(3), "abc");
        assertThat(m.containsKey(20), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void testThatWeCantPutNullKey() {
        m.put(null, "abc");
    }

    @Test
    public void testThatNewMapHasZeroSize() {
        assertThat(m.size(), is(0));
    }

    @Test
    public void testIfWeAddDataSizeWillIncrease() {
        m.put(new Integer(3), "abc");
        m.put(new Integer(5), "abc");

        assertThat(m.size(), is(2));
    }

    @Test
    public void testThatMapCanPutPairWithKeyThatAlreadyPresented() {
        m.put(new Integer(5), "dwd");
        m.put(new Integer(5), "4r");
        m.put(new Integer(4), "dwd");
        m.put(new Integer(5), "4r");

        assertThat(m.containsValue("dwd"), is(true));
        assertThat(m.containsValue("4r"), is(true));

    }

    @Test
    public void testThatWeCanPut1000DifferentKeysInMap() {
        IntStream.range(1, 1000).forEach(
                i -> m.put(i, String.valueOf(i))
        );
        IntStream.range(1, 1000).forEach(
                i -> assertTrue(m.containsKey(i))
        );
    }

    @Test
    public void testThatMapCanContainKeysWithSameHashCode() {
        Object testChar = new Character('z');
        Object testInt = new Integer(122);

        assertEquals(testChar.hashCode(), testInt.hashCode());

        m2.put(testChar, "dwd");
        m2.put(testInt, "sqq");

        assertTrue(m2.containsKey(testChar));
        assertTrue(m2.containsKey(testInt));

    }

    @Test
    public void testThatThatIfMapContainsKeyWithSameHashCodePutMethodWillReturnPreviousValue() {
        Object testChar = new Character('z');
        Object testInt = new Integer(122);

        assertEquals(testChar.hashCode(), testInt.hashCode());

        String testValue1 = m2.put(testChar, "dwd");
        String testValue2 = m2.put(testInt, "sqq");

        assertThat(testValue1, is(testValue2));

        assertEquals(testValue2, null);

    }

    @Test
    public void testThatIfMapContainsKeyWithSameHashCodeAfterPutSizeWillChange() {
        Object testChar = new Character('z');
        Object testInt = new Integer(122);

        assertEquals(testChar.hashCode(), testInt.hashCode());

        m2.put(testChar, "dwd");
        m2.put(testInt, "sqq");

        assertThat(m2.size(), is(2));
    }

    @Test
    public void testThatIfMapContainsKeyWithSameHashCodeAfterRemoveSizeWillChange() {
        Object testChar = new Character('z');
        Object testInt = new Integer(122);

        assertEquals(testChar.hashCode(), testInt.hashCode());

        m2.put(testChar, "dwd");
        m2.put(testInt, "sqq");

        m2.remove(testInt);

        assertThat(m2.size(), is(1));
    }

    @Test
    public void testThatIfMapContainsKeyWithSameHashCodeAfterRemovePreviousValueReturns() {
        Object testChar = new Character('z');
        Object testInt = new Integer(122);

        assertEquals(testChar.hashCode(), testInt.hashCode());

        m2.put(testChar, "dwd");
        m2.put(testInt, "sqq");

        assertThat(m2.remove(testInt), is("dwd"));
    }

    @Test
    public void testThatGetMethodCanReturnValueByKey() {
        m.put(new Integer(5), "aaa");

        assertThat(m.get(5), is("aaa"));
    }

    @Test(expected = NullPointerException.class)
    public void testThatGetMethodThrowsExceptionOnNullKey() {
        assertThat(m.get(null), is(false));
    }


    @Test(expected = NullPointerException.class)
    public void testThatContainsKeyMethodThrowsExceptionOnNullKey() {
        assertThat(m.containsKey(null), is(false));
    }

    @Test
    public void testThatContainsKeyMethodReturnsFalseOnWrongKeyClass() {
        m.put(1, "ggg");
        assertThat(m.containsKey("zzz"), is(false));
    }

    @Test
    public void testContainsValueMethodWorksProperlyOn() {
        m.put(new Integer(10), "zzz");

        assertThat((m.containsValue("zzz")), is(true));
    }

    @Test
    public void testContainsValueMethodWorksProperlyOnNullInputValue() {
        m.put(new Integer(5), null);

        assertThat((m.containsValue(null)), is(true));
    }

    @Test
    public void testValueContainsMethodReturnsFalseOnWrongInputValueClass() {
        m.put(100, "ffff");
        assertThat(m.containsValue(120), is(false));
    }

    @Test
    public void testThatWeCanDeleteByKey() {
        m.put(100, "ffff");
        m.put(100, "ffff");
        m.put(25, "aaaa");
        m.remove(100);
        m.remove(25);
        assertThat(m.containsKey(100), is(false));
        assertThat(m.containsKey(25), is(false));
    }

    @Test
    public void testRemoveUnexistentKeyReturnsNull() {
        m.put(100, "ffff");
        assertEquals(m.remove(10), null);
    }

    @Test
    public void testThatWeCanClearEntireMap() {
        fillMap();

        m.clear();

        assertThat(m.size(), is(0));
    }

    @Test
    public void testThatWeCanCopyAnotherMapToOurMap() {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(14, "ffff");
        hashmap.put(100, "ffff");
        hashmap.put(232, "qwswd");
        m.putAll(hashmap);

        assertThat(m.containsKey(232), is(true));
        assertThat(m.containsKey(100), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void testThatWeCantCopyAnotherMapToOurMapIfItsKeyIsNull() {
        Map<Integer, String> hashmap = new HashMap<>();
        hashmap.put(null, "d");
        m.putAll(hashmap);
    }

    @Test(expected = NullPointerException.class)
    public void testThatWeCantCopyAnotherMapToOurMapIfItsNull() {
        m.putAll(null);
    }

    @Test
    public void keySetTest() {
        fillMap();

        Set<Integer> keySet = m.keySet();
        keySet.remove(14);
        assertThat(m.containsKey(14), is(false));

        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            assertTrue(m.containsKey(iterator.next()));
        }

        keySet.clear();
        assertThat(m.isEmpty(), is(true));

        assertEquals(keySet.size(), m.size());
    }

    @Test
    public void testThatIfKeySetChangesElementsOurHashMapWillChangeToo(){
        fillMap();

        Set<Integer> keySet = m.keySet();

        assertThat(keySet.size(), is(m.size()));

        for (Integer key : keySet) {
            keySet.remove(key);
        }

        assertThat(keySet.isEmpty(), is(true));
        assertThat(m.isEmpty(), is(true));
    }


    @Test (expected = UnsupportedOperationException.class)
    public void testThatWeCantAddToKeySet() {
        Set<Integer> keySet = m.keySet();

        keySet.add(new Integer(2));
    }

    @Test
    public void valueCollectionTest() {
        fillMap();

        Collection<String> valueCollection = m.values();

        assertThat(valueCollection.contains("qwswd"), is(true));

        Iterator<String> iterator = valueCollection.iterator();
        while (iterator.hasNext()) {
            assertTrue(m.containsValue(iterator.next()));
        }

        valueCollection.clear();
        assertThat(m.isEmpty(), is(true));

        assertEquals(valueCollection.size(), m.size());
    }

    @Test
    public void testThatValueCollectionChangesElementsOurHashMapWillChangeToo(){
        fillMap();

        Collection<String> valueCollection = m.values();

        assertThat(valueCollection.size(), is(m.size()));

        for (String value : valueCollection) {
            valueCollection.remove(value);
        }

        assertThat(valueCollection.isEmpty(), is(true));
        assertThat(m.isEmpty(), is(true));
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testThatWeCantAddToValueCollection() {
        Collection<String> valueCollection = m.values();

        valueCollection.add(new String("s"));
    }


    @Test
    public void entrySetTest() {
        fillMap();

        Set<Map.Entry<Integer, String>> entrySet = m.entrySet();

        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();

        assertEquals(entrySet.size(), m.size());

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        assertThat(m.isEmpty(), is(true));

        fillMap();

        for (Map.Entry<Integer, String> entry : entrySet) {
            assertThat(m.containsKey(entry.getKey()), is(true));
            assertThat(m.get(entry.getKey()), is(entry.getValue()));
            if (m.containsKey(entry.getKey() == 14)) {
                assertThat(entrySet.contains(entry), is(true));
            }
            if (m.containsKey(entry.getKey() == 250)) {
                assertThat(entrySet.contains(entry), is(false));
            }
        }
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testThatWeCantAddToEnrtySet() {
        Set entrySet = m.entrySet();

        entrySet.add(new Integer(1));
    }

    @Test
    public void testThatIfEntrySetChangesElementsOurHashMapWillChangeToo(){
        fillMap();

        Set<Map.Entry<Integer, String>> entrySet = m.entrySet();

        assertThat(entrySet.size(), is(m.size()));

        for (Map.Entry<Integer, String> entry : entrySet) {
            entrySet.remove(entry);
        }

        assertThat(entrySet.isEmpty(), is(true));
        assertThat(m.isEmpty(), is(true));
    }


    private void fillMap() {
        m.put(14, "ffff");
        m.put(100, "ffff");
        m.put(2, "wdw");
        m.put(234, "wdwq");
        m.put(232, "qwswd");
        m.put(4, "wdqdq");
        m.put(423423, "qwqwqw");
    }

}