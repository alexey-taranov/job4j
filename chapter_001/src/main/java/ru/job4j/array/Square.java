package ru.job4j.array;

public class Square {
    /**
     * заполняем массив элементами от 1 до bound возведенными в квадрат
     * @param bound размер массива.
     * @return массив заполненный элементами от 1 до bound возведенными в квадрат.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int index = 0; index != rst.length; index++) {
            rst[index] = (int) Math.pow(index + 1, 2);
        }
        return rst;
    }
}
