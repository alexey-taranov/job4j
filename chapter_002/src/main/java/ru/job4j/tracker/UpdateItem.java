package ru.job4j.tracker;

import java.util.function.Consumer;

public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        output.accept("Редактирование заявки.");
        String id = input.ask("Введите id заявки для ее изменения: ");
        String name = input.ask("Введите новое имя заявки: ");
        String desc = input.ask("Введите новое описание заявки: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (tracker.replace(id, item)) {
            output.accept("Заявка отредактирована.");
        } else {
            output.accept("Заявка НЕ отредактирована.");
        }
    }
}
