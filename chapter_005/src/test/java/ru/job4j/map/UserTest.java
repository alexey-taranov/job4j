package ru.job4j.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void whenAddSomeUsers() {
        User user1 = new User("Alex", 0, new GregorianCalendar(1997, Calendar.JULY, 13));
        User user2 = new User("Vladimir", 10, new GregorianCalendar(1990, Calendar.JULY, 7));
        User user3 = new User("Alex", 0, new GregorianCalendar(1997, Calendar.JULY, 13));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "User1");
        map.put(user2, "User2");
        map.put(user3, "User3");
        System.out.println(map);
    }

    @Test
    public void whenAddTwoUsers() {
        User user1 = new User("Alex", 0, new GregorianCalendar(1997, Calendar.JULY, 13));
        User user2 = new User("Alex", 0, new GregorianCalendar(1997, Calendar.JULY, 13));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "User1");
        map.put(user2, "User2");
        System.out.println(map);
    }
}
