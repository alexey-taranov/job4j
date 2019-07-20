package ru.job4j.testTaskTest;

import org.junit.Test;
import ru.job4j.testTask.TestTask;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TestTaskTest {
    @Test
    public void whenTestStudentSortWithOutNullObjects() {
        Integer[] arrayFirstTest = {2, 5, 7, 8, 3, 4, 0};
        Integer[] arraySecondTest = {10, 1, 4, 9, 2};

        TestTask task = new TestTask();
        int firstTest = task.filterArrays(arrayFirstTest, (num) -> num % 2 == 0);
        int secondTest = task.filterArrays(arraySecondTest, (num) -> num % 2 == 0);

        assertThat(84, is(firstTest));
        assertThat(120, is(secondTest));
    }
}
