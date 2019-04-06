package ru.job4j.array;

public class MatrixCheck {
    /**
     * проверяет, что все элементы по диагоналям равны true или false.
     * @param data массив.
     * @return результат.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i != data.length - 1; i++) {
            if (data[i][i] != data[i + 1][i + 1]
                    || data[i][data.length - 1 - i] != data[i + 1][data.length - 2 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}
