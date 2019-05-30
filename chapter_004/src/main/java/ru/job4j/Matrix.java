package ru.job4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matrix {

    List<Integer> convertMatrix(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(Arrays::stream).collect(Collectors.toList());

    }
}
