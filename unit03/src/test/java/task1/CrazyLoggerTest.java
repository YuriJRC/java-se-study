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
    public void addMessageTest() {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("hello");
        logger.addMessage(null);
        logger.addMessage("world");

        logger.printLog();

        assertTrue(logger.getLogger().length()>0);
        assertTrue(logger.getLogger().substring(0, 25).contains("hello"));
    }

    @Test
    public void searchEntriesByMessageTest() {
        CrazyLogger logger = new CrazyLogger();

        logger.addMessage("ipsum");
        logger.addMessage("dolor");
        logger.addMessage("Lorem ipsum dolor sit amet consectetur adipisci");

        assertTrue(logger.searchEntriesByMessage(null).equals("Wrong input"));
        assertTrue(logger.searchEntriesByMessage("").equals("Wrong input"));

        assertTrue(logger.searchEntriesByMessage("hello").equals("No matches found"));

        assertTrue(logger.searchEntriesByMessage("ipsum").contains("ipsum") &&
                logger.searchEntriesByMessage("ipsum").contains("Lorem ipsum dolor sit amet consectetur adipisci"));

       assertTrue(logger.searchEntriesByMessage("dolor").substring(19, 24).equals("dolor"));

       logger.printLog();
    }

    @Test
    public void searchByData() {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("ipsum");
        logger.addMessage("dolor");
        logger.addMessage("sit");

        System.out.println(logger.searchEntriesByData("12-15-2017"));
        System.out.println(logger.searchEntriesByData("27-02-2017"));
        System.out.println(logger.searchEntriesByData("27.02.2017"));
    }
}
