package ru.job4j.departament;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DepartamentTest {

    @Test
    public void whenTestSortByUp() {
        Departament departament = new Departament();
        departament.addUnit("K1/SK1");
        departament.addUnit("K1/SK2");
        departament.addUnit("K1/SK1/SSK1");
        departament.addUnit("K1/SK1/SSK2");
        departament.addUnit("K2");
        departament.addUnit("K2/SK1/SSK1");
        departament.addUnit("K2/SK1/SSK2");
        departament.sortByUp();

        List<String> test = Arrays.asList("K1/SK1", "K1/SK1/SSK1", "K1/SK1/SSK2", "K1/SK2",
                "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");
        assertThat(departament.storage, is(test));
    }

    @Test
    public void whenTestSortByDown() {
        Departament departament = new Departament();
        departament.addUnit("K1/SK1");
        departament.addUnit("K1/SK2");
        departament.addUnit("K1/SK1/SSK1");
        departament.addUnit("K1/SK1/SSK2");
        departament.addUnit("K2");
        departament.addUnit("K2/SK1/SSK1");
        departament.addUnit("K2/SK1/SSK2");
        departament.sortByDown();

        List<String> test = Arrays.asList("K2/SK1/SSK2", "K2/SK1/SSK1",
                "K2", "K1/SK2", "K1/SK1/SSK2", "K1/SK1/SSK1", "K1/SK1");
        assertThat(departament.storage, is(test));
    }
}
