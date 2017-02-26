package com.epam.java.se.task5;

import java.util.*;

/**
 * Created by Мария on 24.02.2017.
 */
public class GroupManager {
    private ArrayList <Group> groups;
    private Map<String, List> result;

    public GroupManager(){
        groups = new ArrayList<>();
        result = new LinkedHashMap<>();
    }

    public void setGroup(Group group) {
        groups.add(group);
    }

    public void returnStudentAndMark(Student student) {
        Map<Discipline, Number> marksForDiscipline = new HashMap<>();
        for (int i=0; i<groups.size(); i++) {
            if (groups.get(i).isStudent(student.getName())) {

                Number mark = groups.get(i).getStudents().get(student);
                marksForDiscipline.put(groups.get(i).getDiscipline(), mark);

                List list = new ArrayList(marksForDiscipline.entrySet());
                Collections.sort( list, (Comparator<Map.Entry<Discipline, Number>>) (o1, o2) -> {
                    int res = Double.compare(o1.getValue().doubleValue(),o2.getValue().doubleValue());
                    return res;
                });
                result.put(student.getName(),list);
            }
        }
    }

    public void printResult(){
            if (result==null){
                throw new NullPointerException();
            }
        for (Map.Entry entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


}
