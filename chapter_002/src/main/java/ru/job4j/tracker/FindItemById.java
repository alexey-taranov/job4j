package ru.job4j.tracker;

public class FindItemById implements UserAction {

    private int key;
    private String info;

    public FindItemById(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Поиск заявки по id");
        String id = input.ask("Введите id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Время создания заявки: " + item.getTime());
            System.out.println("id заявки: " + item.getId());                       // пробел
            System.out.println("Имя заявки: " + item.getName());
            System.out.println("Описание заявки: " + item.getDesc());
        } else {
            System.out.println("Заявки с таким id отсутствуют.");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
}
