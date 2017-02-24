package com.epam.java.se.task5;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Мария on 24.02.2017.
 */
public class GroupManager {
    private ArrayList <Group> groups;

    public GroupManager(){
        groups = new ArrayList<>();
    }

    public void setGroup(Group group) {
        groups.add(group);
    }

    public HashMap <Student, Number> returnStudentAndMark(Student student) {
        HashMap  <Student, Number> singleStudent = new HashMap<>();
        for (int i=0; i<groups.size(); i++) {
            if (groups.get(i).isStudent(student.getName())) {
                Number m = groups.get(i).getStudents().get(student);
                System.out.println(student.getName() + ": " + groups.get(i).getDiscipline()+" - "+m);
            }
        }
        return singleStudent;
    }

}
