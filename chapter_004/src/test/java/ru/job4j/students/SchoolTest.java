package ru.job4j.students;


import org.junit.Test;

import java.util.List;


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
}
