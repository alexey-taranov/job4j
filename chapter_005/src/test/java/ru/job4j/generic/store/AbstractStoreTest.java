package ru.job4j.generic.store;

import org.junit.Test;
import ru.job4j.generic.SimpleArray;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AbstractStoreTest {

    @Test
    public void whenElementAdd() {
        AbstractStore store = new UserStore(new SimpleArray<>(5));
        User user0 = new User("0");
        User user1 = new User("1");
        User user2 = new User("2");
        store.add(user0);
        store.add(user1);
        store.add(user2);
        assertThat(store.findById("1"), is(user1));
    }

    @Test
    public void whenElementReplace() {
        AbstractStore store = new UserStore(new SimpleArray<>(5));
        User user0 = new User("0");
        User user1 = new User("1");
        store.add(user0);
        store.add(user1);
        store.replace("0", user1);
        assertThat(store.findById("0"), is(user1));
    }

    @Test
    public void whenElementRemove() {
        AbstractStore store = new UserStore(new SimpleArray<>(5));
        User user0 = new User("0");
        User user1 = new User("1");
        store.add(user0);
        store.add(user1);
        store.delete("0");
        assertThat(store.findById("0"), is(user1));
    }
}
