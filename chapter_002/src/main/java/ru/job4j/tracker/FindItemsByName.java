package ru.job4j.tracker;

public class FindItemsByName implements UserAction {

    private int key;
    private String info;

    public FindItemsByName(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Поиск заявки по имени");
        String key = input.ask("Введите имя заявки: ");
        for (Item item : tracker.findByName(key)) {
            System.out.println("Время создания заявки:" + item.getTime());
            System.out.println("id заявки: " + item.getId());               //пробел
            System.out.println("Имя заявки: " + item.getName());
            System.out.println("Описание заявки: " + item.getDesc());
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
}
