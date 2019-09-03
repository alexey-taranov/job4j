package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenLoadConfig() {
        Config config = new Config("C:\\projects\\job4j\\app.properties");
        config.load();
        assertThat(
                config.value("hibernate.connection.url"),
                is("jdbc:postgresql://127.0.0.1:5432/trackstudio")
        );
    }

    @Test (expected = java.lang.UnsupportedOperationException.class)
    public void whenNotContainKey() {
        Config config = new Config("C:\\projects\\job4j\\app.properties");
        config.load();
        config.value("aaaaaaaaaaaaaaaaaaa");

    }
}
