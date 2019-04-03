package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version 1.0.0
 * @since 03.04.2019
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

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
        this.items[this.position++] = item;
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
        for (int i = 0; i != position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                item.setId(id);
                items[i] = item;
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
        boolean result = false;
        for (int i = 0; i != position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, items, i, this.position - i);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод получает список всех заявок .
     * @return - все элементы трекера.
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод получает список заявок по имени из хранилища.
     * @param key искомое имя.
     */
    public Item[] findByName(String key) {
        Item[] result;
        int pos = 0;
        for (int i = 0; i != position; i++) {
            pos += this.items[i].getName().equals(key) ? 1 : 0;
        }
        result = new Item[pos];
        pos = 0;
        for (int i = 0; i != position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[pos++] = this.items[i];
            }
        }
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