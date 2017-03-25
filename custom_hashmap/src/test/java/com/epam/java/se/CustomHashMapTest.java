package com.epam.java.se;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.Map;

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
    private Map<String, String> m2;

    @Before
    public void init() {
        m = new CustomHashMap<>();
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

    @Test (expected = NullPointerException.class)
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
        m.put(14, "ffff");
        m.put(100, "ffff");
        m.put(2, "aaaa");
        m.put(234, "aaaa");
        m.put(232, "aaaa");
        m.put(4, "aaaa");
        m.put(423423, "aaaa");

        m.clear();

        assertThat(m.size(), is(0));
    }

}