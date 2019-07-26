package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

import java.util.NoSuchElementException;

public class AbstractStore<T extends Base> implements Store<T> {

    SimpleArray<T> array;

    public AbstractStore(SimpleArray<T> array) {
        this.array = array;
    }

    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (Integer.valueOf(id) < array.getSize() && Integer.valueOf(id) >= 0) {
            array.set(Integer.valueOf(id), model);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        if (Integer.valueOf(id) < array.getSize() && Integer.valueOf(id) >= 0) {
            array.remove(Integer.valueOf(id));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        if (Integer.valueOf(id) < array.getSize() && Integer.valueOf(id) >= 0) {
            return array.get(Integer.valueOf(id));
        } else {
            throw new NoSuchElementException();
        }
    }
}
