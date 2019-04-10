package ru.job4j.tracker;

public class DeleteItem implements UserAction {

    private int key;
    private String info;

    public DeleteItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }


    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Удаление заявки.");
        String id = input.ask("Введите id заявки для ее удаления: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена.");
        } else {
            System.out.println("Заявка НЕ удалена.");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
}
