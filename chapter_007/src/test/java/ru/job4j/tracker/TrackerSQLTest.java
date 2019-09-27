package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TrackerSQLTest {
    @Test
    public void checkConnection() throws SQLException {
        TrackerSQL sql = new TrackerSQL(ConnectionRollback.create(this.init()));
        assertThat(sql.init(), is(true));
    }

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void whenCreateTwoItemsWithSameNameThenGetListOfTwoItems() {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            List<Item> in = List.of(
                    new Item("item", "desc1", System.currentTimeMillis()),
                    new Item("item", "desc2", System.currentTimeMillis())
            );
            for (Item item : in) {
                tracker.add(item);
            }
            List<Item> search = tracker.findByName("item");
            assertThat(search.size(), is(2));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
