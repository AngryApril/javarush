package com.javarush.task.task29.task2909.human;

/**
 * Created by alexey.valiev on 11/2/18.
 */
public class UniversityPerson extends Human{
    protected String name;
    protected int age;
    private University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public UniversityPerson(String name, int age, int numberOfStudents) {

        super(name, age, numberOfStudents);
    }

    public University getUniversity() { return university; }

    public void setUniversity(University university) { this.university = university;
    }
}
