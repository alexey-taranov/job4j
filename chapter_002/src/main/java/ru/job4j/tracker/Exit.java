package ru.job4j.tracker;

public class Exit implements UserAction {

    private int key;
    private String info;

    public Exit(int key, String info) {
        this.key = key;
        this.info = info;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public void execute(Input input, Tracker tracker) {

    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.info);
    }
}

