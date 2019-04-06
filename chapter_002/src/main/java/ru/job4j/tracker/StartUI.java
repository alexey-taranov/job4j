package ru.job4j.tracker;

public class StartUI {

    private static final String ADD = "0";
    private static final String SHOWALL = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findIdItem();
            } else if (FINDNAME.equals(answer)) {
                this.findNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с id : " + item.getId() + "-----------");
    }

    /**
     * Метод показывает меню трекера.
     */
    private void showMenu() {
        System.out.println("Меню. \n 0. Add new Item \n 1. Show all items \n 2. Edit item \n "
                + "3. Delete item \n 4. Find item by Id \n 5. Find items by name \n 6. Exit Program \n Select:");
    }

    /**
     * Метод показывает список всех заявок.
     */
    private void showAllItem() {
        System.out.println("Список всех заявок: \n -----------------------");
        int count = 0;
        for (Item item : this.tracker.findAll()) {
            System.out.println("Date: " + item.getTime());
            System.out.println("Id: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Decs: " + item.getDesc() + "\n -----------------------");
            count++;
        }
        System.out.println("Всего заявок: " + count);
    }

    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private void editItem() {
        System.out.println("Редактирование заявки.");
        String id = this.input.ask("Введите id заявки для ее изменения: ");
        String name = this.input.ask("Введите новое имя заявки: ");
        String desc = this.input.ask("Введите новое описание заявки: ");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (this.tracker.replace(id, item)) {
            System.out.println("Заявка отредактирована.");
        } else {
            System.out.println("Заявка НЕ отредактирована.");
        }
    }

    /**
     * Метод реализует удаление заявки в хранилище.
     */
    private void deleteItem() {
        System.out.println("Удаление заявки.");
        String id = this.input.ask("Введите id заявки для ее удаления: ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка удалена.");
        } else {
            System.out.println("Заявка НЕ удалена.");
        }
    }

    /**
     * Метод реализует поиск заявки по id в хранилище.
     */
    private void findIdItem() {
        System.out.println("Поиск заявки по id");
        String id = this.input.ask("Введите id заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Время создания заявки: " + item.getTime());
            System.out.println("id заявки: " + item.getId());
            System.out.println("Имя заявки: " + item.getName());
            System.out.println("Описание заявки: " + item.getDesc());
        } else {
            System.out.println("Заявки с таким id отсуствуют.");
        }
    }

    /**
     * Метод реализует поиск заявки по имени в хранилище.
     */
    private void findNameItem() {
        System.out.println("Поиск заявки по имени");
        String key = this.input.ask("Введите имя заявки: ");
        for (Item item : this.tracker.findByName(key)) {
            System.out.println("Время создания заявки:" + item.getTime());
            System.out.println("id заявки: " + item.getId());
            System.out.println("Имя заявки: " + item.getName());
            System.out.println("Описание заявки: " + item.getDesc());
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
