package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("Поиск заявки по имени");
        String key = input.ask("Введите имя заявки: ");
        for (Item item : tracker.findByName(key)) {
            output.accept("Время создания заявки:" + item.getTime());
            output.accept("id заявки: " + item.getId());               //пробел
            output.accept("Имя заявки: " + item.getName());
            output.accept("Описание заявки: " + item.getDesc());
        }
    }
}
