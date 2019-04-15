package ru.job4j.tracker;

public class FindItemById extends BaseAction {


    public FindItemById(int key, String info) {
        super(key, info);
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
}
