package ru.job4j.testTask;

import java.util.Arrays;
import java.util.function.Predicate;

public class TestTask {

    public Integer filterArrays(Integer[] array, Predicate<Integer> predict) {
        return Arrays.stream(array)
                .filter(predict).mapToInt(num -> num * num)
                .reduce(0, Integer::sum);
    }
}
