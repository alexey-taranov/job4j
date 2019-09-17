package ru.job4j.tracker;

import java.util.function.Consumer;

public class Exit extends BaseAction {

    public Exit(int key, String info, Consumer<String> output) {
        super(key, info, output);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
    }
}

