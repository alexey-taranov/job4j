package ru.job4j.array;

public class BubbleSort {

    public int[] sort(int[] array) {
        for (int i = array.length - 1; i != 0; i--) {
            for (int index = 0; index != i; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }
}
