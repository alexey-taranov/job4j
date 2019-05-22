package ru.job4j.cashmachine;

import java.util.ArrayList;
import java.util.List;

public class CashMachine {

    private final int[] values;

    public CashMachine(final int[] values) {
        this.values = values;
    }

    public List<List<Integer>> exchange(int note) {
        int counter = 0;
        List<List<Integer>> change = new ArrayList<>();
        if (values.length > 0) {
            for (int i = 0; i < values.length; i++) {
                if (note % values[i] == 0) {
                    int supNote = note;
                    change.add(new ArrayList<>());
                    while (supNote > 0) {
                        change.get(counter).add(values[i]);
                        supNote -= values[i];
                    }
                    supNote = note;
                    if (values.length - 1 >= i + 1
                            && supNote / values[i + 1] > 0
                            && supNote / values[i] > 1
                            && values[i] + values[i + 1] <= note) {
                        change.add(new ArrayList<>());
                        counter++;
                        supNote -= values[i];
                        while (supNote > 0) {
                            change.get(counter).add(values[i + 1]);
                            supNote -= values[i + 1];
                        }
                        change.get(counter).add(values[i]);
                    }
                    counter++;
                }
            }
        }
        return change;
    }
}
