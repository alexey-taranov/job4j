package ru.job4j.loop;

public class Counter {
    /**
     * Складывает четные числа из заданного промежутка.
     * @param start начальное значение.
     * @param finish конечное значение.
     * @return Сумма.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i  = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
