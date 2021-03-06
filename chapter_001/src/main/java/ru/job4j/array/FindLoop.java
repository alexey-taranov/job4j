package ru.job4j.array;

public class FindLoop {
    /**
     * поиска элемента в массиве
     * @param data массив.
     * @param el искомый элемент.
     * @return индекс искомого элемента.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index != data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
