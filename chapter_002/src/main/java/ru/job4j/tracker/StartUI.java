package ru.job4j.tracker;

public class StartUI {

//    private static final String ADD = "0";
//    private static final String SHOWALL = "1";
//    private static final String EDIT = "2";
//    private static final String DELETE = "3";
//    private static final String FINDID = "4";
//    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.init();
    }

    public void init() {
        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        while (!exit) {
            menu.show();
            String answer = this.input.ask("select:");
            menu.select(Integer.valueOf(answer));
            if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
