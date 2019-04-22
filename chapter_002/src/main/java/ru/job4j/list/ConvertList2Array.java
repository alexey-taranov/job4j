package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1);
        int[][] array = new int[rows][cells];
        int index = 0;
        for (int numberOfList : list) {
            array[index / rows][index % rows] = numberOfList;
            index++;
        }
        return array;
    }
}
