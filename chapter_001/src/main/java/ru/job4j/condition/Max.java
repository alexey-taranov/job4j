package ru.job4j.condition;

public class Max {
    public int max(int left, int right) {
        int result = left > right  ? left : right;
        return result;
    }

    public int max(int first, int second, int third) {
        int result = first > second  ? first : second;
        result = result > third  ? result : third;
        return result;
    }

    public int max(int first, int second, int third, int fourth) {
        int result = max(first, second, third);
        result = result > fourth  ? result : fourth;
        return result;
    }
}
