package task3;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Мария on 01.03.2017.
 */
public class LinksSearcher {
    private static final Pattern LINK_PATTERN = Pattern.compile("[(]?[Рр]ис(([.]?\\s?)|(ун((ок)|(ки)|(ке)|(ков)|(ком)|(а))))\\s?([0-9]+)\\s?(и)?\\s?([0-9]+)?[)]?");
    private static final Pattern SENTENCE_PATTERN = Pattern.compile("([А-ЯA-Z](|[^?!.(]|\\([^)]*\\))*[.?!])");
    private static final String FILE_PATH = "Java.SE.03.Information handling_task_attachment.html";
    private StringBuilder sequenceBuilder = new StringBuilder();
    private Matcher linkMatcher, sentenceMatcher;


    public void readSentences() {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(FILE_PATH), "windows-1251"));
            while ((line = reader.readLine()) != null) {
                sequenceBuilder.append(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public StringBuilder getSequenceBuilder() {
        return sequenceBuilder;
    }

    public boolean areLinksInRightOrder() {
        if (sequenceBuilder == null || sequenceBuilder.toString().equals("")) {
            throw new NullPointerException("No text found");
        }
        linkMatcher = LINK_PATTERN.matcher(sequenceBuilder);
        int start = 0;
        while (linkMatcher.find()) {
            int numberOfGroup = Integer.valueOf(linkMatcher.group(11));
            if (start < numberOfGroup) {
                start = numberOfGroup;
            } else {
                return false;
            }
        }
        return true;
    }

    public String getAllSentencesWithLinks() {
        StringBuilder result = new StringBuilder();
        if (sequenceBuilder == null || sequenceBuilder.toString().equals("")) {
            throw new NullPointerException("No text found");
        }
        sentenceMatcher = SENTENCE_PATTERN.matcher(sequenceBuilder);
        while (sentenceMatcher.find()){
            linkMatcher = LINK_PATTERN.matcher(sentenceMatcher.group());
            if (linkMatcher.find()){
                result.append(sentenceMatcher.group()).append("\n");
            }
        }
        return result.toString();
    }
}

