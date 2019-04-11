package ru.job4j.tracker;

public class StartUI {

    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) throws MenuOutException {
        this.input = input;
        this.tracker = tracker;
        this.init();
    }

    public void init() throws MenuOutException {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        String answer = this.input.ask("select:");
        do {
            menu.show();
            menu.select(input.ask("select:", menu.getRangeActions()));
        } while (!"y".equals(answer));
    }

    public static void main(String[] args) throws MenuOutException {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
