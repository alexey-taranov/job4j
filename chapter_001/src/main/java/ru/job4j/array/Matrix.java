package ru.job4j.array;

public class Matrix {

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                table[i][k] = (i + 1) * (k + 1);
            }
        }
        return table;
    }
}
