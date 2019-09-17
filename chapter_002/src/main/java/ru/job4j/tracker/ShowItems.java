package ru.job4j.tracker;


import java.util.function.Consumer;

public class ShowItems extends BaseAction {


    public ShowItems(int key, String info, Consumer<String> output) {
       super(key, info, output);
    }

    @Override
    public void execute(Input input, ITracker tracker) {
        output.accept("Список всех заявок:");
        output.accept("-----------------------");
        for (Item item : tracker.findAll()) {
            output.accept(item.toString());
            output.accept("-----------------------");
        }
    }
}
