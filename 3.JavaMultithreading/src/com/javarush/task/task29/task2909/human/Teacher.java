package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends UniversityPerson {

    public Teacher(String name, int age, int numberOfStudents) {
        super(name,age,numberOfStudents);
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    public String getPosition(){return "Преподаватель";}
}