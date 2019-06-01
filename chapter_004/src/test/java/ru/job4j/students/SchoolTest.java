package ru.job4j.students;


import org.junit.Test;

import java.util.List;
import java.util.Map;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    @Test
    public void whenTestStudentSortWithOutNullObjects() {
        List<Student> students = List.of(
                new Student(79),
                new Student(81),
                new Student(55),
                new Student(10),
                new Student(59),
                new Student(25),
                new Student(80)
        );
        School school = new School();
        List<Student> studentAfterSortHigherThan70 = school.collect(students, (s) -> s.getScore() > 70);
        List<Student> studentAfterSortHigherThan50 = school.collect(students, (s) -> s.getScore() > 50 && s.getScore() <= 70);
        List<Student> studentAfterSortHigherThan0 = school.collect(students, (s) -> s.getScore() > 0 && s.getScore() <= 50);

        assertThat(79, is(studentAfterSortHigherThan70.get(0).getScore()));
        assertThat(81, is(studentAfterSortHigherThan70.get(1).getScore()));
        assertThat(80, is(studentAfterSortHigherThan70.get(2).getScore()));

        assertThat(55, is(studentAfterSortHigherThan50.get(0).getScore()));
        assertThat(59, is(studentAfterSortHigherThan50.get(1).getScore()));

        assertThat(10, is(studentAfterSortHigherThan0.get(0).getScore()));
        assertThat(25, is(studentAfterSortHigherThan0.get(1).getScore()));
    }

    @Test
    public void whenTestStudentSort() {
        Student ivanov = new Student("Ivanov");
        Student petrov = new Student("Petrov");
        Student ololov = new Student("Ololov");
        List<Student> students = List.of(
                ivanov,
                petrov,
                ololov
        );
        School school = new School();
        Map<String, Student> studentsWithSurname = school.collectToMap(students);

        assertThat(ivanov, is(studentsWithSurname.get("Ivanov")));
        assertThat(petrov, is(studentsWithSurname.get("Petrov")));
        assertThat(ololov, is(studentsWithSurname.get("Ololov")));
    }

    @Test
    public void whenTestStudentsScore() {
        Student ivanov = new Student(40, "Ivanov");
        Student petrov = new Student(80, "Petrov");
        Student ololov = new Student(70, "Ololov");
        List<Student> students = List.of(
                ivanov,
                petrov,
                ololov
        );
        School school = new School();
        List<Student> studentsWithHighScore = school.levelOf(students, 60);

        assertThat(petrov, is(studentsWithHighScore.get(0)));
        assertThat(ololov, is(studentsWithHighScore.get(1)));
    }
}
