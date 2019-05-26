package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindItemById extends BaseAction {


    public FindItemById(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        output.accept("Поиск заявки по id");
        String id = input.ask("Введите id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            output.accept("Время создания заявки: " + item.getTime());
            output.accept("id заявки: " + item.getId());                       // пробел
            output.accept("Имя заявки: " + item.getName());
            output.accept("Описание заявки: " + item.getDesc());
        } else {
            output.accept("Заявки с таким id отсутствуют.");
        }
    }
}
