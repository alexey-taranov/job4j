package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    public final static String LS = System.lineSeparator();
    public final static String MENU = new StringBuilder()
            .append("Меню. ").append(LS)
            .append("0. Add new Item ").append(LS)
            .append("1. Show all items ").append(LS)
            .append("2. Edit item ").append(LS)
            .append("3. Delete item ").append(LS)
            .append("4. Find item by Id ").append(LS)
            .append("5. Find items by name ").append(LS)
            .append("6. Exit Program ").append(LS)
            .append("Select:").toString();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenShowThenShowAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        Input input = new StubInput(new String[]{"1", "6"});
        tracker.add(item);
        new StartUI(input, tracker).init();
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("Список всех заявок:").append(LS);
        sb.append("-----------------------").append(LS);
        sb.append(item).append(LS);
        sb.append("-----------------------").append(LS);
        sb.append(MENU).append(LS);
        assertThat(out.toString(), is(sb.toString()));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        Item delItem = null;
        assertThat(tracker.findById(item.getId()), is(delItem));
    }

    @Test
    public void whenFindByIdThenShowItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        tracker.add(item);
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("Поиск заявки по id").append(LS);
        sb.append("Время создания заявки: " + item.getTime()).append(LS);
        sb.append("id заявки: " + item.getId()).append(LS);
        sb.append("Имя заявки: " + item.getName()).append(LS);
        sb.append("Описание заявки: " + item.getDesc()).append(LS);
        sb.append(MENU).append(LS);
        assertThat(out.toString(), is(sb.toString()));
    }

    @Test
    public void whenFindByNameThenShowItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test name", "desc", System.currentTimeMillis());
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        tracker.add(item);
        new StartUI(input, tracker).init();
        StringBuilder sb = new StringBuilder();
        sb.append(MENU).append(LS);
        sb.append("Поиск заявки по имени").append(LS);
        sb.append("Время создания заявки:" + item.getTime()).append(LS);
        sb.append("id заявки: " + item.getId()).append(LS);
        sb.append("Имя заявки: " + item.getName()).append(LS);
        sb.append("Описание заявки: " + item.getDesc()).append(LS);
        sb.append(MENU).append(LS);
        assertThat(out.toString(), is(sb.toString()));
    }
}