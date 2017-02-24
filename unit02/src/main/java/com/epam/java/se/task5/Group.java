package com.epam.java.se.task5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Мария on 24.02.2017.
 */
public class Group {
    private Discipline discipline;
    private HashMap<Student, Mark> students;

    public Group (Discipline discipline){
        this.discipline=discipline;
        students = new HashMap<>();

    }

    public boolean isStudent(String name) {
        for (Map.Entry<Student, Mark> entry : students.entrySet()){
            if (name.equals(entry.getKey().getName())){
                return true;
            }
        }
        return false;
    }

    public void addStudent(Student name, Mark mark) {
        students.put(name, mark);
    }

    public HashMap<Student, Mark> getStudents() {
        return students;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return "" + students;
    }
}
