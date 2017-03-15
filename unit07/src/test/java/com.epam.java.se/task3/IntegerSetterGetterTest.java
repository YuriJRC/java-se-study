package com.epam.java.se.task3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Мария on 15.03.2017.
 */
public class IntegerSetterGetterTest {
    SharedResource res;

    @Before
    public void init()throws Exception {
        res = new SharedResource();
    }

    @Test
    public void setElementTest() throws Exception{
        res.setElement(1);
        res.setElement(6);
        res.setElement(null);

        for (int i=0; i<res.getList().size(); i++){
            assertTrue(res.getList().get(0)==1 &&
                    res.getList().get(1)==6 && res.getList().get(2)==null);
        }
    }
    @Test
    public void getElementTest() throws Exception{

        assertTrue(res.getElement()==null);

        res.setElement(null);
        assertTrue(res.getElement()==null);

        res.setElement(-500);
        res.setElement(Integer.MAX_VALUE);

        assertTrue(res.getElement()==-500);

        assertTrue(res.getList().size()==1);
        assertTrue(res.getList().get(0)==Integer.MAX_VALUE);
    }

}
