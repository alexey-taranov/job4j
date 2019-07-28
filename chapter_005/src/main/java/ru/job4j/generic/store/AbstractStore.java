package ru.job4j.generic.store;

import ru.job4j.generic.SimpleArray;

public class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> array;

    public AbstractStore(SimpleArray<T> array) {
        this.array = array;
    }

    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int ind = findIndex(id);
        if (ind != -1) {
            array.set(ind, model);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        int ind = findIndex(id);
        if (ind != -1) {
            array.remove(ind);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        int ind = findIndex(id);
        return ind != -1 ? array.get(ind) : null;
    }

    public int findIndex(String id) {
        int index = -1;
        int pos = 0;
        for (T element : array) {
            if (element.getId().equals(id)) {
                index = pos;
                break;
            }
            pos++;
        }
        return index;
    }
}
