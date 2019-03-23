package ru.job4j.converter;

/**
 * Конвертор валюты.
 */
public class Converter {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return 70 / value;
    }

    /**
     * Конвертируем рубли в доллар.
     * @param value рубли.
     * @return доллар.
     */
    public int rubleToDollar(int value) {
        return 60 / value;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value евро.
     * @return рубли
     */
    public int euroToRuble(int value) {
        return 70 * value;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return рубли.
     */
    public int dollarToRuble(int value) {
        return 60 * value;
    }
}
