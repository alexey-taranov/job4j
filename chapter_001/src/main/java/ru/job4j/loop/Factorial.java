package ru.job4j.loop;

public class Factorial {
    /**
     * Находит факториал заданного числа.
     * @param n заданное число.
     * @return значение факториала.
     */
    public int calc(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}