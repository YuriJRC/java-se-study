package com.epam.java.se;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Мария on 25.03.2017.
 */

@FixMethodOrder
public class CustomHashMapTest {

    private Map<Integer, String> m;

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
    public void testThatWeCanPutNullValue() {
    }

    @Test(expected = OutOfMemoryError.class)
    public void testThatMapHaveInfiniteCapacity() {

    }

    @Test
    public void testThatMapCanPutPairWithKeyThatAlreadyPresented() {
    }

    @Test
    public void testThatMapCanContainsKeysWithSameHashCode() {
    }

    @Test(expected = NullPointerException.class)
    public void testThatContainsKeyMethodThrowsExceptionOnNullKey() {
    }

    @Test(expected = ClassCastException.class)
    public void testThatContainsKeyMethodThrowsExceptionOnWrongKeyClass() {
    }

    @Test
    public void testContainsValueMethodWorksProperlyOn() {
    }

    @Test
    public void testContainsValueMethodWorksProperlyOnNullInputValue() {
    }

    @Test(expected = ClassCastException.class)
    public void testValueContainsMethodThrowsExceptionOnWrongInputValueClass() {
    }

    @Test
    public void testThatMapCalculateItsSizeProperly() {
    }


}