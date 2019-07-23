package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> iter = it.next();

            @Override
            public boolean hasNext() {
                while (!iter.hasNext()) {
                    if (it.hasNext()) {
                        iter = it.next();
                    } else {
                        break;
                    }
                }
                return iter.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iter.next();
            }
        };
    }
}
