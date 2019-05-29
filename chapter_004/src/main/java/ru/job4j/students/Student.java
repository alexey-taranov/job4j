package ru.job4j.students;

public class Student {

    private int score;
    private String surname;

    public Student(int score) {
        this.score = score;
    }

    public Student(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }
}
