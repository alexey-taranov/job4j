package ru.job4j.comparator;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenUserSort() {
        List<User> users = List.of(
                new User("Alex", 23),
                new User("Bob", 10),
                new User("John", 34),
                new User("Jim", 99),
                new User("Shawn", 200));

        SortUser sortUser = new SortUser();
        Set<User> userSet = sortUser.sort(users);
        List<User> userTest = new ArrayList<>(userSet);

        assertThat(10, is(userTest.get(0).getAge()));
        assertThat(23, is(userTest.get(1).getAge()));
        assertThat(34, is(userTest.get(2).getAge()));
        assertThat(99, is(userTest.get(3).getAge()));
        assertThat(200, is(userTest.get(4).getAge()));
    }

    @Test
    public void whenSortNameLength() {
        List<User> users = List.of(
                new User("Alex", 16),
                new User("William", 20),
                new User("Shawn", 41),
                new User("John", 60));

        SortUser sort = new SortUser();
        List<User> userTest = sort.sortNameLength(users);

        assertThat("Alex", is(userTest.get(0).getName()));
        assertThat("John", is(userTest.get(1).getName()));
        assertThat("Shawn", is(userTest.get(2).getName()));
        assertThat("William", is(userTest.get(3).getName()));
    }

    @Test
    public void whenSortByAllFields() {
        List<User> users = List.of(
                new User("Сергей", 25),
                new User("Сергей", 20),
                new User("Иван", 25),
                new User("Иван", 30));

        SortUser sort = new SortUser();
        List<User> userTest = sort.sortByAllFields(users);

        assertThat("Иван", is(userTest.get(0).getName()));
        assertThat("Иван", is(userTest.get(1).getName()));
        assertThat("Сергей", is(userTest.get(2).getName()));
        assertThat("Сергей", is(userTest.get(3).getName()));

        assertThat(25, is(userTest.get(0).getAge()));
        assertThat(30, is(userTest.get(1).getAge()));
        assertThat(20, is(userTest.get(2).getAge()));
        assertThat(25, is(userTest.get(3).getAge()));
    }
}
