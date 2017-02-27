package task1;

import org.junit.Test;

/**
 * Created by Мария on 27.02.2017.
 */
public class CrazyLoggerTest {
    @Test
    public void addMessageTest() {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("hello");
        logger.addMessage(null);
        logger.addMessage("world");

        logger.printLog();
    }

    @Test
    public void searchInfoTest() {
        CrazyLogger logger = new CrazyLogger();

        logger.addMessage("ipsum");
        logger.addMessage("dolor");
        logger.addMessage("Lorem ipsum dolor sit amet consectetur adipisci");

        System.out.println(logger.searchEntriesByMessage(null));
        System.out.println(logger.searchEntriesByMessage(""));
        System.out.println(logger.searchEntriesByMessage("ipsum"));
        System.out.println(logger.searchEntriesByMessage("dolor"));
        System.out.println(logger.searchEntriesByMessage("amet consectetur"));
        System.out.println(logger.searchEntriesByMessage("hello"));

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
