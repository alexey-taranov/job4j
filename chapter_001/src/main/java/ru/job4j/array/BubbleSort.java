package ru.job4j.array;

public class BubbleSort {

    public int[] sort(int[] array) {

        for (int i = 1; i != array.length; i++) {
            for (int index = 1; index != array.length; index++) {

                if (index + 1 != array.length && array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
        return array;
    }
}
