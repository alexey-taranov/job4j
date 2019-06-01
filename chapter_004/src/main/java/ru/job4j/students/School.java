package ru.job4j.students;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }

    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream().distinct().collect(
                Collectors.toMap(
                        Student::getSurname,
                        e -> e));
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted((o1, o2) -> {
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return  -1;
            }
            return Integer.compare(o2.getScore(), o1.getScore());
        }).flatMap(Stream::ofNullable).takeWhile(v -> v.getScore() > bound)
                .collect(Collectors.toList());
    }
}
