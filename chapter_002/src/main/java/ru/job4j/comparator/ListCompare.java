package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rst = 0;
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            Character leftChar = left.charAt(i);
            rst = leftChar.compareTo(right.charAt(i));
            if (rst != 0) {
                break;
            }
        }
        if (rst == 0) {
            Integer leftInt = left.length();
            rst = leftInt.compareTo(right.length());
        }
        return rst;
    }
}
