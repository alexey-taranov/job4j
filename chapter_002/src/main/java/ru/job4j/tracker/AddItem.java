package ru.job4j.tracker;

public class AddItem implements UserAction {

    private int key;
    private String info;

    public AddItem(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }


    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("------------ Новая заявка с id : " + item.getId() + "-----------");
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
}

