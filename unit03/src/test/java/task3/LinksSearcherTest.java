package task3;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Мария on 02.03.2017.
 */
public class LinksSearcherTest {
    @Test
            (expected = NullPointerException.class)
    public void nullTest() {
        LinksSearcher linksSearcher = new LinksSearcher();

        linksSearcher.getSequenceBuilder();
        linksSearcher.areLinksInRightOrder();
        linksSearcher.getAllSentencesWithLinks();
    }

    @Test
    public void readSentencesTest() throws Exception {
        LinksSearcher linksSearcher = new LinksSearcher();

        linksSearcher.readSentences();

        assertTrue(linksSearcher.getSequenceBuilder().length() > 0);

    }

    @Test
    public void areLinksInRightOrderTest() {
        LinksSearcher linksSearcher = new LinksSearcher();

        linksSearcher.readSentences();

        assertFalse(linksSearcher.areLinksInRightOrder());

    }

    @Test
    public void getAllSentencesWithLinksTest() {
        LinksSearcher linksSearcher = new LinksSearcher();

        linksSearcher.readSentences();

        System.out.println(linksSearcher.getAllSentencesWithLinks());

        assertTrue(linksSearcher.getAllSentencesWithLinks().contains("рис") ||
                linksSearcher.getAllSentencesWithLinks().contains("Рис."));
    }

}
