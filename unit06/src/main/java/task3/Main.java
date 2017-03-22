package task3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Мария on 22.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        List<? extends Object> list4 = new ArrayList<Doctor>();
        System.out.println(list4);
    }
}
