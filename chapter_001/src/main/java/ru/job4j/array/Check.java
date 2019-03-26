package ru.job4j.array;

public class Check {
    /**
     * проверяет, что все элементы в массиве являются true или false.
     * @param data массив.
     * @return верно ли утверждение, что все элементы в массиве являются true или false.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 1; index != data.length; index++ ) {
            if (data[0] != data[index]) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}