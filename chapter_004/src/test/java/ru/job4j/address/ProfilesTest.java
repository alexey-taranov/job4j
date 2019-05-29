package ru.job4j.address;

import org.junit.Test;


import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    @Test
    public void whenTestStudentSortWithOutNullObjects() {
        Address moscow = new Address("Moscow", "Lenina", 11, 22);
        Address perm = new Address("Perm", "Pushkina", 33, 44);
        Address newYork = new Address("New York", "Broadway", 55, 66);
        List<Profile> profiles = List.of(
                new Profile(moscow),
                new Profile(perm),
                new Profile(newYork)
        );
        Profiles profile = new Profiles();
        List<Address> addressOfProfiles = profile.collect(profiles);
        assertThat(moscow, is(addressOfProfiles.get(0)));
        assertThat(perm, is(addressOfProfiles.get(1)));
        assertThat(newYork, is(addressOfProfiles.get(2)));
    }
}
