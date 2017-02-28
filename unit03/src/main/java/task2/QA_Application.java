package task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Мария on 28.02.2017.
 */
public class QA_Application {
    private static ResourceBundle questions, answers;
    private static ArrayList<String> keys;
    private static Locale locale;

    public static void runApplication() {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Choose language(Выберите язык):\nenglish(английский) - 1 \n" +
                    "russian(русский) - 2\nexit(выход) - 3");
            try {
                String input = reader.readLine();
                if (input.equals("1")) {
                    locale = new Locale("en", "UK");
                    questions = ResourceBundle.getBundle("Questions_en_UK", locale);
                    answers = ResourceBundle.getBundle("Answers_en_UK", locale);
                    keys = new ArrayList<>(Collections.list(questions.getKeys()));
                    System.out.println("Input number of question and get an answer");
                    for (String value : keys) {
                        System.out.println(questions.getString(value));
                    }
                    input = reader.readLine();
                    if (keys.contains(String.valueOf(input))){
                        System.out.println(answers.getString(input));
                    }
                    else System.out.println("Wrong input");
                }
                else if (input.equals("2")) {
                    locale = new Locale("ru", "RU");
                    questions = ResourceBundle.getBundle("Questions_ru_RU", locale);
                    answers = ResourceBundle.getBundle("Answers_ru_RU", locale);
                    keys = new ArrayList<>(Collections.list(questions.getKeys()));
                    System.out.println("Введите номер вопроса и узнайте ответ");
                    for (String value : keys) {
                        System.out.println(questions.getString(value));
                    }
                    input = reader.readLine();
                    if (keys.contains(String.valueOf(input))){
                        System.out.println(answers.getString(input));
                    }
                    else System.out.println("Неверный ввод");
                }
                else if (input.equals("3")) {
                    break;
                }
                else{
                    System.out.println("Wrong input(Неверный ввод)");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
