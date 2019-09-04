package ru.job4j.io;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SearchTest {

    private final static String PATH = System.getProperty("java.io.tmpdir") + "/JavaSearchTest";
    private static File dir1 = new File(PATH + "/dir1");
    private static File dir2 = new File(PATH + "/dir2");

    @Before
    public void createSystem() throws IOException {
        new File(PATH).mkdir();
        dir1.mkdir();
        dir2.mkdir();
        new File(dir1, "11.doc").createNewFile();
        new File(dir1, "12.txt").createNewFile();
        new File(dir1, "13.txt").createNewFile();
        new File(dir2, "21.jpg").createNewFile();
        new File(dir2, "22.txt").createNewFile();
        new File(dir2, "23.pdf").createNewFile();
    }

    @Test
    public void whenSearchExtensionThenResult() {
        Search search = new Search();
        List<String> searchList = Arrays.asList(".doc", ".pdf");
        List<String> searchTxtList = Arrays.asList(".txt");
        assertThat(search.files(PATH, searchList).size(), is(2));
        assertThat(search.files(PATH, searchTxtList).size(), is(3));
    }
}
