package ru.job4j.students;

import java.util.Comparator;

public class Student implements Comparator<Student> {

    private int score;
    private String surname;

    public Student(int score) {
        this.score = score;
    }

    public Student(String surname) {
        this.surname = surname;
    }

    public Student(int score, String surname) {
        this.score = score;
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getScore(), o2.getScore());
    }
}
