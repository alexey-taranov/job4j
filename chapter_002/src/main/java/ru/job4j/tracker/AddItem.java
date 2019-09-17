package ru.job4j.tracker;

import java.util.function.Consumer;

class AddItem extends BaseAction {

    public AddItem(int key, String name, Consumer<String> output) {
        super(key, name, output);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        String name = input.ask("Enter name:");
        String desc = input.ask("Enter description:");
        tracker.add(new Item(name, desc, System.currentTimeMillis()));
    }
}