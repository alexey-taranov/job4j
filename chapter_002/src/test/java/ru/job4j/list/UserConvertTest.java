package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenTestUser() {
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(1, "Ivan", "Novgorod"));
        listUser.add(new User(2, "Petr", "Perm"));
        listUser.add(new User(3, "Alex", "Saratov"));
        UserConvert userConvert = new UserConvert();
        HashMap<Integer, User> mapUser = userConvert.process(listUser);
        assertThat(mapUser.get(1), is(new User(1, "Ivan", "Novgorod")));
        assertThat(mapUser.get(3), is(new User(3, "Alex", "Saratov")));
        assertThat(mapUser.get(2), is(new User(2, "Petr", "Perm")));
    }
}
