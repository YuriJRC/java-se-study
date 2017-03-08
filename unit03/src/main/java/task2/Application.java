package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Мария on 08.03.2017.
 */
public class Application {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private ResourceManager manager = new ResourceManager();
    private ResourceBundle questions, answers;
    private String input;

    public void init() throws IOException {
        chooseLanguage();
        setLocaleAndBundle();
        getQuestions();
        showQuestions();
        showAnswers();
    }

    public void chooseLanguage() {
        System.out.println("Choose language:\nenglish - 1 \n" +
                "russian - 2\nexit - 3");
    }

    public void setLocaleAndBundle() throws IOException, MissingResourceException {
        Locale locale;
        input = reader.readLine();
        if (input.equals("1")) {
            locale = manager.setLocale("en", "UK");
            questions = manager.setResourceBundle("Questions_en_UK", locale);
            answers = manager.setResourceBundle("Answers_en_UK", locale);
        } else if (input.equals("2")) {
            locale = manager.setLocale("ru", "RU");
            questions = manager.setResourceBundle("Questions_ru_RU", locale);
            answers = manager.setResourceBundle("Answers_ru_RU", locale);
        } else if (input.equals("3")) {
            System.exit(0);
        } else {
            System.out.println("Wrong input");
            chooseLanguage();
            setLocaleAndBundle();
        }
    }

    public ArrayList<String> getQuestions() throws MissingResourceException {
        if (questions == null) {
            throw new NullPointerException("Empty data");
        }
        return new ArrayList<>(Collections.list(questions.getKeys()));
    }

    public void showQuestions() throws MissingResourceException{
        if (questions == null) {
            throw new NullPointerException("Empty data");
        }
        getQuestions();
        for (String value : getQuestions()) {
            System.out.println(questions.getString(value));
        }
    }

    public void showAnswers() throws IOException, MissingResourceException {
        if (answers == null){
            throw new NullPointerException("Empty data");
        }
        System.out.println("Press \"q\" to exit");
        System.out.println("Press \"b\" to return to menu");
        getQuestions();
        while ((input = reader.readLine()) != null) {
            if (getQuestions().contains(input)) {
                System.out.println(answers.getString(input));
            } else if (quit().equals(input)) {
                System.exit(0);
            } else if (backToMenu().equals(input)) {
                init();
            }
            else {
                System.out.println("Wrong input");
            }
        }

    }

    public String quit() {
        return "q";
    }

    public String backToMenu() {
        return "b";
    }


}
