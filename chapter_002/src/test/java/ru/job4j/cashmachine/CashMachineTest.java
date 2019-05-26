package ru.job4j.cashmachine;

import org.junit.Test;
import java.util.List;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashMachineTest {
    @Test
    public void unchange() {
        CashMachine machine = new CashMachine(new int[] {1, 5, 10});
        List<List<Integer>> result = machine.exchange(1);
        assertThat(result, is(singletonList(singletonList(1))));
    }

    @Test
    public void five() {
        CashMachine machine = new CashMachine(new int[] {1, 5, 10});
        List<List<Integer>> result = machine.exchange(5);
        assertThat(result, is(
                asList(
                        asList(1, 1, 1, 1, 1),
                        asList(5)
                )
        ));
    }

    @Test
    public void change() {
        CashMachine machine = new CashMachine(new int[] {10, 5, 1});
        List<List<Integer>> result = machine.exchange(10);
        assertThat(
                result, is(
                        asList(
                                singletonList(10),
                                asList(5, 5),
                                asList(1, 1, 1, 1, 1, 5),
                                asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
                        )
                )
        );
    }

    @Test
    public void when15to10and5() {
        CashMachine machine = new CashMachine(new int[] {10, 5, 1});
        int[]expect = {10, 5};
        int[] result = machine.change(50, 35);
        assertThat(result, is(expect));
    }
    @Test
    public void when30to3for10() {
        CashMachine machine = new CashMachine(new int[] {10, 5, 1});
        int[] expect = {10, 10, 10};
        int[] result = machine.change(50, 20);
        assertThat(result, is(expect));
    }
    @Test
    public void whentestallnumber() {
        CashMachine machine = new CashMachine(new int[] {10, 5, 1});
        int[] expect = {10, 5, 1, 1, 1};
        int[] result = machine.change(50, 32);
        assertThat(result, is(expect));
    }
}
