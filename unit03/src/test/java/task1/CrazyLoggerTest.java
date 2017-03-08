package task1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Мария on 27.02.2017.
 */
public class CrazyLoggerTest {
    @Test
            (expected = NullPointerException.class)
    public void nullPointerExceptionTest() throws Exception{
        CrazyLogger logger = null;
        logger.printLog();
    }

    @Test
    public void addMessageTest() throws Exception{
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("hello");
        logger.addMessage(null);
        logger.addMessage("world");

        logger.printLog();

        assertTrue(logger.getLogger().length()>0);
        assertTrue(logger.getLogger().substring(0, 25).contains("hello"));
    }

    @Test
    public void searchEntriesByMessageTest() throws Exception{
        CrazyLogger logger = new CrazyLogger();

        logger.addMessage("ipsum");
        logger.addMessage("dolor");
        logger.addMessage("Lorem ipsum dolor sit amet consectetur adipisci");

        assertTrue(logger.searchEntriesByMessage(null).equals("wrong input"));
        assertTrue(logger.searchEntriesByMessage("").equals("wrong input"));

        assertTrue(logger.searchEntriesByMessage("hello").equals("no matches found"));

        assertTrue(logger.searchEntriesByMessage("ipsum").contains("ipsum") &&
                logger.searchEntriesByMessage("ipsum").contains("Lorem ipsum dolor sit amet consectetur adipisci"));

       assertTrue(logger.searchEntriesByMessage("dolor").substring(19, 24).equals("dolor"));

       logger.printLog();
    }

    @Test
    public void searchEntriesByDataTest() throws Exception{
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("ipsum");
        logger.addMessage("dolor");
        logger.addMessage("sit");

        assertTrue(logger.searchEntriesByData(null).equals("input can't be null"));

        assertTrue(logger.searchEntriesByData("rwe.wfwe.wefwefwfw").equals("wrong format"));
        assertTrue(logger.searchEntriesByData("rwe.wfwe.wefwefwfw").equals("wrong format"));

        assertTrue(logger.searchEntriesByData("01-01-2017").equals("no matches found"));

        assertTrue(logger.searchEntriesByData("07-03-2017").contains("sit"));

    }
}
