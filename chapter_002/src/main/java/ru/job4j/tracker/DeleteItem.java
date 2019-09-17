package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        output.accept("Удаление заявки.");
        String id = input.ask("Введите id заявки для ее удаления: ");
        if (tracker.delete(id)) {
            output.accept("Заявка удалена.");
        } else {
            output.accept("Заявка НЕ удалена.");
        }
    }
}
