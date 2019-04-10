package ru.job4j.tracker;

public class ShowItems implements UserAction {

    private int key;
    private String info;

    public ShowItems(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("Список всех заявок:");
        System.out.println("-----------------------");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
            System.out.println("-----------------------");
        }
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
}
