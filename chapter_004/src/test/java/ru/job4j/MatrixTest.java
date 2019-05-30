package ru.job4j;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MatrixTest {

    @Test
    public void whenMatrixEquals1234() {
        Integer[][] matrix = new Integer[][] {{0, 1}, {2, 3}};
        Matrix mtrx = new Matrix();
        List<Integer> result = mtrx.convertMatrix(matrix);
        assertThat(result, is(List.of(0, 1, 2, 3)));
    }
}
