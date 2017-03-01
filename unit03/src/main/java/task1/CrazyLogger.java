package task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Мария on 27.02.2017.
 */
public class CrazyLogger {
    private StringBuilder logger;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY:hh-mm");

    public CrazyLogger (){
        logger = new StringBuilder();
    }

    public void addMessage(String message){
        if (message == null ){
            return;
        }
        logger.append(LocalDateTime.now().format(formatter) + " - ");
        logger.append(message + "\n");

    }

    public StringBuilder getLogger() {
        return logger;
    }

    public void printLog() {
        System.out.println(logger.toString());
    }

    public String searchEntriesByMessage(String message){
        StringBuilder result = new StringBuilder();
        String [] separator = logger.toString().split("\\n");
        if (message == null || message.equals("")){
            return result.append("Wrong input").toString();
        }
        for (int i=0; i<separator.length; i++){
            if (separator[i].indexOf(message,
                    LocalDateTime.now().format(formatter).length()+3) !=-1){
                result.append(separator[i] + "\n");
            }
        }
        if (result.toString().equals("")) {
            return result.append("No matches found").toString();
        }
        return result.toString();
    }

    public String searchEntriesByData(String inputDate){
        StringBuilder result = new StringBuilder();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        String [] separator = logger.toString().split("\\n");
        try {
            Date date = dateFormatter.parse(inputDate);
            String formattedDate = dateFormatter.format(date);
            for (int i=0; i<separator.length; i++){
                if (separator[i].substring(0, formattedDate.length()).equals(formattedDate)){
                    result.append(separator[i] + "\n");
                }
            }
            if (result.toString().equals("")) {
                return result.append("No matches found" + "\n").toString();
            }
        } catch (ParseException e) {
            System.out.println("Wrong format");
        }
        return result.toString();
    }
}
