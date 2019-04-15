package ru.job4j.tracker;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String info) {
       super(key, info);
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
}
