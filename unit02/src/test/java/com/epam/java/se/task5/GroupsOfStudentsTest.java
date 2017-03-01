package com.epam.java.se.task5;

import org.junit.Test;

/**
 * Created by Мария on 24.02.2017.
 */
public class GroupsOfStudentsTest {
    @Test
           (expected = IllegalArgumentException.class)
    public void valuesThatNotFollowContract() throws Exception{
            Student student = new Student(null, "aaa");
            Student student2 = new Student("aaa", "bbb");
            Group groupMaths = new Group(Discipline.MATHEMATICS);
            groupMaths.addDoubleMark(student, 5.6);
            groupMaths.addDoubleMark(student2, 15.6);
            groupMaths.addIntegerMark(student, 10); // must be not > 5
    }

    @Test
    public void groupsTest() throws Exception{

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
