package com.epam.java.se.tesk5;

import com.epam.java.se.task5.*;
import org.junit.Test;

/**
 * Created by Мария on 24.02.2017.
 */
public class GroupsOfStudentsTest {
    @Test
    public void groupsTest() throws Exception{

        Student student = new Student("Vasya");
        Student student2 = new Student("Masha");
        Student student3 = new Student("Yura");
        Student student4 = new Student("Petya");
        Student student5 = new Student("Kuzja");
        Student student6 = new Student("Valdemar");

        Group groupMaths = new Group(Discipline.MATHEMATICS);
        groupMaths.addStudent(student, new Mark<>(5));
        groupMaths.addStudent(student2, new Mark<>(4));

        Group groupGEO = new Group(Discipline.GEOGRAPHIC);
        groupGEO.addStudent(student, new Mark<>(5));
        groupGEO.addStudent(student3, new Mark<>(3));

        Group groupInformatics = new Group(Discipline.INFORMATICS);
        groupGEO.addStudent(student4, new Mark<>(5.8));
        groupGEO.addStudent(student5, new Mark<>(3.4));
        groupGEO.addStudent(student2, new Mark<>(7.7));

        Group groupPhysics = new Group(Discipline.PHYSICS);
        groupPhysics.addStudent(student, new Mark<>(5.6));
        groupPhysics.addStudent(student6, new Mark<>(8.8));
        groupPhysics.addStudent(student5, new Mark<>(3.4));
        groupPhysics.addStudent(student2, new Mark<>(11.7));
        groupPhysics.addStudent(student5, new Mark<>(5.7));

        GroupManager gm = new GroupManager();
        gm.setGroup(groupMaths);
        gm.setGroup(groupGEO);
        gm.setGroup(groupInformatics);
        gm.setGroup(groupPhysics);

        gm.returnStudentAndMark(student);
    }
}
