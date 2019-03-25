package ru.job4j.array;

public class Check {
    /**
     * проверяет, что все элементы в массиве являются true или false.
     * @param data массив.
     * @return верно ли утверждение, что все элементы в массиве являются true или false.
     */
    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index != data.length; index++ ) {
            if ( index + 1 != data.length && data[index] == data[index + 1]) {
                result = true;
            }
        }
        return result;
    }
}
