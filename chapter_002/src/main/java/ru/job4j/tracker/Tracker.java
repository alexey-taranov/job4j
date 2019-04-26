package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @version 1.0.0
 * @since 03.04.2019
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>(100);

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище.
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(this.position, item);
        position++;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод редактирует заявки по уникальному ключу.
     * @param id Уникальный ключ.
     * @param item Новая заявка.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                item.setId(id);
                items.add(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет заявки по уникальному ключу.
     * @param id Уникальный ключ.
     */
    public boolean delete(String id) {
        for (int out = 0; out < items.size(); out++) {
            if (items.get(out) != null && items.get(out).getId().equals(id)) {
                List<Item> listToCopy = items;
                for (int k = out; k < 99; k++) {
                    items.add(k, listToCopy.get(k + 1));
                }
                items.add(99, null);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод получает список всех заявок .
     * @return - все элементы трекера.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        result.addAll(0, this.items);
        return result;
    }

    /**
     * Метод получает список заявок по имени из хранилища.
     * @param key искомое имя.
     */
    public List<Item> findByName(String key) {
        //массив для сохранения найденных итемов
        List<Item> result = new ArrayList<>();
        int k = 0;
        for (Item item: items) {
            if (item != null && item.getName().equals(key)) {
                result.add(k, item);
                //result.add(item);
                k++;
            }
        }

        //List<Item> resultCopy = new ArrayList<>();
        //resultCopy.addAll(0, result);
        return result;
    }

    /**
     * Метод получает заявку по уникальному ключу из хранилища.
     * @param id - уникальный ключ.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}