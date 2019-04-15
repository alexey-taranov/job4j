package ru.job4j.tracker;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String info) {
        super(key, info);
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
}
