package com.epam.java.se.task5;

import org.junit.Test;

/**
 * Created by Мария on 24.02.2017.
 */
public class GroupsOfStudentsTest {
    @Test
    public void contractTest() throws Exception{
        Student student = new Student(null);
        Student student2 = new Student("aaa");
        Group groupMaths = new Group(Discipline.MATHEMATICS);
        groupMaths.addMark(student, 5.6);
        groupMaths.addMark(student, 10);
    }

    @Test
    public void groupsTest() throws Exception{

        Student student = new Student("Vasya");
        Student student2 = new Student("Masha");
        Student student3 = new Student("Yura");
        Student student4 = new Student("Petya");
        Student student5 = new Student("Kuzja");
        Student student6 = new Student("Valdemar");

        Group groupMaths = new Group(Discipline.MATHEMATICS);
        groupMaths.addMark(student, 5);
        groupMaths.addMark(student2, 4);
        groupMaths.addMark(student3, 2);

        Group groupGEO = new Group(Discipline.GEOGRAPHIC);
        groupGEO.addMark(student, 3);
        groupGEO.addMark(student3, 1);

        Group groupInformatics = new Group(Discipline.INFORMATICS);
        groupInformatics.addMark(student4, 2.7);
        groupInformatics.addMark(student5, 3.1);
        groupInformatics.addMark(student2, 2.9);
        groupInformatics.addMark(student3, 1.9);

        Group groupPhysics = new Group(Discipline.PHYSICS);
        groupPhysics.addMark(student4, 4.7);
        groupPhysics.addMark(student, 4.6);
        groupPhysics.addMark(student6, 3.2);
        groupPhysics.addMark(student2, 3.6);
        groupPhysics.addMark(student5, 2.2);

        GroupManager gm = new GroupManager();
        gm.setGroup(groupMaths);
        gm.setGroup(groupGEO);
        gm.setGroup(groupInformatics);
        gm.setGroup(groupPhysics);

        gm.returnStudentAndMark(student);
        gm.returnStudentAndMark(student2);
        gm.returnStudentAndMark(student3);
        gm.returnStudentAndMark(student4);
        gm.returnStudentAndMark(student5);
        gm.returnStudentAndMark(student6);

        gm.printResult();

    }
}
