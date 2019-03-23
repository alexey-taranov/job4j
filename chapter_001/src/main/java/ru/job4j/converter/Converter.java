package ru.job4j.converter;

/**
 * Конвертор валюты.
 */
public class Converter {

    public int rubleToEuro(int value) {
        int euro = 70 / value;
        return euro;
    }

    public int rubleToDollar(int value) {
        int dollar = 60 / value;
        return dollar;
    }

    public int euroToDouble(int value) {
        int ruble = 70 * value;
        return ruble;
    }

    public int dollarToRuble(int value) {
        int ruble = 60 * value;
        return ruble;
    }
}
