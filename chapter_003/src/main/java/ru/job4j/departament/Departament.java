package ru.job4j.departament;

import java.util.ArrayList;
import java.util.Collections;

public class Departament {

    ArrayList<String> storage = new ArrayList();

    public void addUnit(String unit) {
        storage.add(unit);
    }

    public void sortByUp() {
        Collections.sort(storage);
    }

    public void sortByDown() {
        Collections.sort(storage);
        Collections.reverse(storage);
    }
}
