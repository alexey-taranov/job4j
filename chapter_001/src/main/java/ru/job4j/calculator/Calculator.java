package ru.job4j.calculator;

public class Calculator {
    /**
     * Сложение.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public double add(double first, double second) {
        return first + second;
    }

    /**
     * Вычитание.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public double substract(double first, double second) {
        return first - second;
    }

    /**
     * Деление.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public double div(double first, double second) {
        return first / second;
    }

    /**
     * Умножение.
     * @param first первое число.
     * @param second второе число.
     * @return результат.
     */
    public double multiple(double first, double second) {
        return first * second;
    }
}