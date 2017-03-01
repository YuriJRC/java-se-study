package com.epam.java.se.task5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Мария on 24.02.2017.
 */
public class GroupsOfStudentsTest {
    @Test
            (expected = IllegalArgumentException.class)
    public void valuesThatNotFollowContract() throws Exception {
        Group groupMaths = new Group(Discipline.MATHEMATICS);

        Student student = new Student(null, "aaa");
        groupMaths.addIntegerMark(student, 4);

        Student student2 = new Student("aaa", "bbb");
        groupMaths.addDoubleMark(student2, 5.6); // must be integer
        groupMaths.addIntegerMark(student2, 10); // must be not > 5
        groupMaths.addDoubleMark(student2, 15.6);
    }

    @Test
    public void addStudentsTest() throws Exception {
        Student student = new Student("Vasya", "Pupkin");
        Student student2 = new Student("Masha", "Ivanova");

        assertTrue(student.getName().equals("Vasya"));
        assertTrue(student2.getSurname().equals("Ivanova"));

    }

    @Test
    public void ifGroupHasStudentTest() throws Exception {
        Group groupPhysics = new Group(Discipline.PHYSICS);
        Group groupInformatics = new Group(Discipline.INFORMATICS);

        Student student3 = new Student("Yura", "Petrov");
        groupPhysics.addDoubleMark(student3, 4.7);

        Student student4 = new Student("Petya", "Sidorov");
        groupInformatics.addDoubleMark(student4, 2.7);

        assertTrue(groupPhysics.hasStudent("Yura", "Petrov"));
        assertFalse(groupInformatics.hasStudent("Petya", "Kot"));
    }

    @Test
    public void addGroupsAndMarksTest() throws Exception {
        Group groupMaths = new Group(Discipline.MATHEMATICS);
        Group groupInformatics = new Group(Discipline.INFORMATICS);

        Student student = new Student("Vasya", "Pupkin");
        groupMaths.addIntegerMark(student, 5);
        groupInformatics.addDoubleMark(student, 2.7);
    }

    @Test
    public void groupManagerSetGroupsMethodTest() throws Exception {
        Group groupGEO = new Group(Discipline.GEOGRAPHIC);
        Group groupMaths = new Group(Discipline.MATHEMATICS);

        Student student = new Student("Vasya", "Pupkin");
        groupGEO.addIntegerMark(student, 3);
        groupMaths.addIntegerMark(student, 5);

        GroupManager gm = new GroupManager();
        gm.setGroup(groupMaths);
        gm.setGroup(groupGEO);

        for (int i = 0; i < gm.getGroups().size(); i++) {
            assertTrue(gm.getGroups().get(0).getDiscipline().equals(Discipline.MATHEMATICS));
            assertTrue(gm.getGroups().get(1).getStudents().containsKey(student));
        }
    }

    @Test
    public void groupManagerGetStudentAndHisMarksSortedTest() throws Exception {
        Group groupMaths = new Group(Discipline.MATHEMATICS);
        Group groupGEO = new Group(Discipline.GEOGRAPHIC);
        Group groupInformatics = new Group(Discipline.INFORMATICS);
        Group groupPhysics = new Group(Discipline.PHYSICS);

        Student student = new Student("Vasya", "Pupkin");
        groupMaths.addIntegerMark(student, 5);
        groupGEO.addIntegerMark(student, 3);
        groupInformatics.addDoubleMark(student, 1.9);
        groupPhysics.addDoubleMark(student, 4.6);

        GroupManager gm = new GroupManager();
        gm.setGroup(groupMaths);
        gm.setGroup(groupGEO);
        gm.setGroup(groupInformatics);
        gm.setGroup(groupPhysics);

        gm.getStudentAndHisMarksSorted(student);

        List<String> expectedValues = new ArrayList<>();
        expectedValues.add("INFORMATICS=1.9");
        expectedValues.add("GEOGRAPHIC=3");
        expectedValues.add("PHYSICS=4.6");
        expectedValues.add("MATHEMATICS=5");

        for (Map.Entry<String, List> entry : gm.getResult().entrySet()){
            assertTrue(entry.getValue().toString().equals(expectedValues.toString()));
        }

        Student student2 = new Student("Masha", "Ivanova");
        groupMaths.addIntegerMark(student2, 4);
        groupGEO.addIntegerMark(student2, 4);
        groupInformatics.addDoubleMark(student2, 2.9);
        groupPhysics.addDoubleMark(student2, 3.6);

        gm.getStudentAndHisMarksSorted(student2);

        gm.printResult();
    }

}
