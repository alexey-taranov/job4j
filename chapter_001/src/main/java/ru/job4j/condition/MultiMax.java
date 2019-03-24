package ru.job4j.condition;

public class MultiMax {
    public int max(int first, int second, int third) {
        int subResult = first > second  ? first : second;
        int result = subResult > third  ? subResult : third;
        return result;
    }
}
