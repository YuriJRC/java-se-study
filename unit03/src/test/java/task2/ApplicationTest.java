package task2;

import org.junit.Before;
import org.junit.Test;

import java.util.MissingResourceException;


/**
 * Created by Мария on 02.03.2017.
 */
public class ApplicationTest {
    private ResourceManager manager;
    private Application application;

    @Before
    public void init()throws Exception {
        manager = new ResourceManager();
        application = new Application();
    }

    @Test
            (expected = NullPointerException.class)
    public void nullPointerExceptionTest() throws Exception{
        manager.setLocale(null);
        manager.setResourceBundle(null, null);
        application.getQuestions();
        application.showAnswers();

    }

    @Test
            (expected = MissingResourceException.class)
    public void missingResourceException() throws Exception{
        manager.setResourceBundle("fake");
    }
}
