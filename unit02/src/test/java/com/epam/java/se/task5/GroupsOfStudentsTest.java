package com.epam.java.se.task5;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Мария on 24.02.2017.
 */
public class GroupsOfStudentsTest {
    @Test
           (expected = IllegalArgumentException.class)
    public void valuesThatNotFollowContract() throws Exception{
            Group groupMaths = new Group(Discipline.MATHEMATICS);

            Student student = new Student(null, "aaa");
            groupMaths.addIntegerMark(student, 4);

            Student student2 = new Student("aaa", "bbb");
            groupMaths.addDoubleMark(student2, 5.6); // must be integer
            groupMaths.addIntegerMark(student2, 10); // must be not > 5
            groupMaths.addDoubleMark(student2, 15.6);
    }

    @Test
    public void addStudentsTest() throws Exception{
        Student student = new Student("Vasya", "Pupkin");
        Student student2 = new Student("Masha", "Ivanova");

        assertTrue(student.getName().equals("Vasya"));
        assertTrue(student2.getSurname().equals("Ivanova"));

    }
    @Test
    public void ifGroupHasStudentTest()throws Exception{
        Student student3 = new Student("Yura", "Petrov");
        Student student4 = new Student("Petya", "Sidorov");

        Group groupPhysics = new Group(Discipline.PHYSICS);
        groupPhysics.addDoubleMark(student3, 4.7);

        Group groupInformatics = new Group(Discipline.INFORMATICS);
        groupInformatics.addDoubleMark(student4, 2.7);

        assertTrue(groupPhysics.hasStudent("Yura", "Petrov"));
        assertFalse(groupInformatics.hasStudent("Petya", "Kot"));
    }

    @Test
    public void addGroupsAndMarksTest() throws Exception{
        Student student = new Student("Vasya", "Pupkin");

        Group groupMaths = new Group(Discipline.MATHEMATICS);
        groupMaths.addIntegerMark(student, 5);

        Group groupInformatics = new Group(Discipline.INFORMATICS);
        groupInformatics.addDoubleMark(student, 2.7);
    }


    @Test
    public void groupManagerTest() throws Exception{

        Student student = new Student("Vasya", "Pupkin");
        Student student2 = new Student("Masha", "Ivanova");
        Student student3 = new Student("Yura", "Petrov");
        Student student4 = new Student("Petya", "Sidorov");
        Student student5 = new Student("Kuzja", "Kot");
        Student student6 = new Student("Valdemar", "Sigizmundov");

        Group groupMaths = new Group(Discipline.MATHEMATICS);
        groupMaths.addIntegerMark(student, 5);
        groupMaths.addIntegerMark(student2, 4);
        groupMaths.addIntegerMark(student3, 2);

        Group groupGEO = new Group(Discipline.GEOGRAPHIC);
        groupGEO.addIntegerMark(student, 3);
        groupGEO.addIntegerMark(student3, 1);
        groupGEO.addIntegerMark(student6, 5);

        Group groupInformatics = new Group(Discipline.INFORMATICS);
        groupInformatics.addDoubleMark(student4, 2.7);
        groupInformatics.addDoubleMark(student5, 3.1);
        groupInformatics.addDoubleMark(student2, 2.9);
        groupInformatics.addDoubleMark(student3, 1.9);

        Group groupPhysics = new Group(Discipline.PHYSICS);
        groupPhysics.addDoubleMark(student4, 4.7);
        groupPhysics.addDoubleMark(student, 4.6);
        groupPhysics.addDoubleMark(student6, 3.2);
        groupPhysics.addDoubleMark(student2, 3.6);
        groupPhysics.addDoubleMark(student5, 2.2);

        GroupManager gm = new GroupManager();
        gm.setGroup(groupMaths);
        gm.setGroup(groupGEO);
        gm.setGroup(groupInformatics);
        gm.setGroup(groupPhysics);

        gm.getStudentAndHisMarksSorted(student);
        gm.getStudentAndHisMarksSorted(student2);
        gm.getStudentAndHisMarksSorted(student3);
        gm.getStudentAndHisMarksSorted(student4);
        gm.getStudentAndHisMarksSorted(student5);
        gm.getStudentAndHisMarksSorted(student6);

        gm.printResult();

    }
}
