package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = s -> stdout.println(s);

    public final static String LS = System.lineSeparator();
    public final static String MENU = new StringBuilder()
            .append("0. Add new Item").append(LS)
            .append("1. Show all items").append(LS)
            .append("2. Edit item").append(LS)
            .append("3. Delete item").append(LS)
            .append("4. Find item by Id").append(LS)
            .append("5. Find items by name").toString();

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output);     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenShowThenShowAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        Input input = new StubInput(new String[]{"1", "y"});
        tracker.add(item);
        new StartUI(input, tracker, output);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("Список всех заявок:").append(LS);
        sb.append("-----------------------").append(LS);
        sb.append(item.toString()).append(LS);
        sb.append("-----------------------").append(LS);
        assertThat(out.toString(), is(sb.toString()));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output);
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
        Item next = new Item("test name2", "desc2", 1234L);
        tracker.add(next);
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        tracker.delete(item.getId());
        // Проверяем, что осталась одна заявка с именем "test name2"
        assertThat(tracker.findAll().get(0).getName(), is("test name2"));
    }

    @Test
    public void whenFindByIdThenShowItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "y"});
        new StartUI(input, tracker, output);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("Поиск заявки по id").append(LS);
        sb.append("Время создания заявки: " + item.getTime()).append(LS);
        sb.append("id заявки: " + item.getId()).append(LS);
        sb.append("Имя заявки: " + item.getName()).append(LS);
        sb.append("Описание заявки: " + item.getDesc()).append(LS);
        assertThat(out.toString(), is(sb.toString()));
    }

    @Test
    public void whenFindByNameThenShowItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        Input input = new StubInput(new String[]{"5", item.getName(), "y"});
        tracker.add(item);
        new StartUI(input, tracker, output);
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("Поиск заявки по имени").append(LS);
        sb.append("Время создания заявки:" + item.getTime()).append(LS);
        sb.append("id заявки: " + item.getId()).append(LS);
        sb.append("Имя заявки: " + item.getName()).append(LS);
        sb.append("Описание заявки: " + item.getDesc()).append(LS);
        assertThat(out.toString(), is(sb.toString()));
    }
}