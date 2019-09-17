package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {

    private final Input input;
    private final ITracker tracker;
    private final Consumer<String> output;

    public StartUI(Input input, ITracker tracker, Consumer<String> output) throws MenuOutException {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
        this.init();
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("select:", menu.getRangeActions()));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));

    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }

}
