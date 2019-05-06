package ru.job4j.comparator;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenUserSort() {
        List<User> users = new ArrayList<>(5);
        users.add(new User("Alex", 23));
        users.add(new User("Bob", 10));
        users.add(new User("John", 34));
        users.add(new User("Jim", 99));
        users.add(new User("Shawn", 200));

        SortUser sortUser = new SortUser();
        Set<User> userSet = sortUser.sort(users);
        List<User> userTest = new ArrayList<>(userSet);

        assertThat(10, is(userTest.get(0).getAge()));
        assertThat(23, is(userTest.get(1).getAge()));
        assertThat(34, is(userTest.get(2).getAge()));
        assertThat(99, is(userTest.get(3).getAge()));
        assertThat(200, is(userTest.get(4).getAge()));
    }
}
