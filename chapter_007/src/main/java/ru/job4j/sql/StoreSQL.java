package ru.job4j.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;
    }

    public void generate(int size) {
        try {
            this.connect = DriverManager.getConnection(config.get("url"));
            PreparedStatement st = this.connect.prepareStatement("create table if not exists entry(field integer)");
            st.executeUpdate();
            try (PreparedStatement prst = this.connect.prepareStatement("insert into entry values (?);")) {
                for (int i = 1; i <= size; i++) {
                    prst.setInt(1, i);
                    prst.execute();
                    prst.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Entry> load() {
        List<Entry> result = new ArrayList();
        try (Statement st = this.connect.createStatement()) {
            ResultSet resultSet = st.executeQuery("select * from entry");
            while (resultSet.next()) {
                result.add(new Entry(resultSet.getInt("field")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }
}