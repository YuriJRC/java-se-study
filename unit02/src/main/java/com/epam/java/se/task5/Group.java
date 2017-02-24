package com.epam.java.se.task5;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Мария on 24.02.2017.
 */
public class Group implements IntegerMark, DoubleMark {
    private Discipline discipline;
    private HashMap<Student, Number> students;

    public Group (Discipline discipline){
        this.discipline=discipline;
        students = new HashMap<>();

    }

    public boolean isStudent(String name) {
        for (Map.Entry<Student, Number> entry : students.entrySet()){
            if (name.equals(entry.getKey().getName())){
                return true;
            }
        }
        return false;
    }

    public HashMap<Student, Number> getStudents() {
        return students;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return "" + students;
    }

    @Override
    public void addMark(Student name, Integer number) {
        if (number>0 && number<=5) {
            switch (discipline) {
                case MATHEMATICS:
                        students.put(name, number);
                case GEOGRAPHIC:
                        students.put(name, number);
            }
        }
        else System.out.println("Wrong number");
    }

    @Override
    public void addMark(Student name, Double number) {
        if (number > 0 && number <= 5) {
            switch (discipline) {
                case INFORMATICS:
                    students.put(name, number);
                case PHYSICS:
                    students.put(name, number);
            }
        } else System.out.println("Wrong number");
    }
}
