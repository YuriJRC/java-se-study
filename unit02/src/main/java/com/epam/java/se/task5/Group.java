package com.epam.java.se.task5;

import java.util.HashMap;
import java.util.Map;

/**
 * Class represent a single group by
 * particular discipline. Contains a Map
 * of students and their marks.
 * Implements interfaces with parametrisation
 * to filter Integer and Double marks
 * @see IntegerMark
 * @see DoubleMark
 *
 * Created by Мария on 24.02.2017.
 */



public class Group implements IntegerMark, DoubleMark {
    private Discipline discipline;
    private HashMap<Student, Number> students;

    public Group (Discipline discipline){
        this.discipline=discipline;
        students = new HashMap<>();

    }

    /**
     * @param name - checks if student is in group,
     * this method is used in GroupManager
     * @see GroupManager#getStudentAndHisMarksSorted(Student)
     * @return true or false
     */
    public boolean hasStudent(String name, String surname) {
        for (Map.Entry<Student, Number> entry : students.entrySet()){
            if (name.equals(entry.getKey().getName()) &&
                    surname.equals(entry.getKey().getSurname())){
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

    /**
     *
     * @param name -add Student to HashMap
     * @param number -add IntegerMark to HashMap
     */
    @Override
    public void addIntegerMark(Student name, Integer number) {
        if (number>0 && number<=5) {
            switch (discipline) {
                case MATHEMATICS:
                        students.put(name, number);
                case GEOGRAPHIC:
                        students.put(name, number);
            }
        } else System.out.println("Wrong number");
    }

    /**
     *
     * @param name -add Student to HashMap
     * @param number -add IntegerMark to HashMap
     */
    @Override
    public void addDoubleMark(Student name, Double number) {
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
