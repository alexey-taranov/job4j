package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;

    public TrackerSQL() {
        init();
        createTable();
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement prst = this.connection.prepareStatement("insert into items(name, descr, time) values (?, ?, ?)")) {
            prst.setString(1, item.getName());
            prst.setString(2, item.getDesc());
            prst.setLong(3, item.getTime());
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        try (PreparedStatement prst = this.connection.prepareStatement("update items set name = ?, descr = ?, time = ? where id = ?")) {
            prst.setString(1, item.getName());
            prst.setString(2, item.getDesc());
            prst.setLong(3, item.getTime());
            prst.setString(4, id);
            prst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try (PreparedStatement prst = this.connection.prepareStatement("delete from items where id = ?")) {
            prst.setString(1, id);
            prst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement prst = this.connection.prepareStatement("select * from items")) {
            ResultSet resSet = prst.executeQuery();
            while (resSet.next()) {
                String name = resSet.getString(2);
                String desc = resSet.getString(3);
                long time = resSet.getLong(4);
                Item item = new Item(name, desc, time);
                result.add(item);
            }
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement prst = this.connection.prepareStatement("select * from items where name = ?")) {
            prst.setString(1, key);
            ResultSet resSet = prst.executeQuery();
            while (resSet.next()) {
                if (resSet.getString("name").equals(key)) {
                    String name = resSet.getString(2);
                    String desc = resSet.getString(3);
                    long time = resSet.getLong(4);
                    Item item = new Item(name, desc, time);
                    result.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(String id) {
        try (PreparedStatement prst = this.connection.prepareStatement("select * from items where id = ?")) {
            prst.setString(1, id);
            ResultSet resSet = prst.executeQuery();
            while (resSet.next()) {
                if (resSet.getString("id").equals(id)) {
                    String name = resSet.getString(2);
                    String desc = resSet.getString(3);
                    long time = resSet.getLong(4);
                    Item item = new Item(name, desc, time);
                    return item;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    public void createTable() {
        try (Statement state = connection.createStatement()) {
            state.executeUpdate("create table if not exists items (id serial primary key, name varchar(40), descr varchar(300), time long)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}