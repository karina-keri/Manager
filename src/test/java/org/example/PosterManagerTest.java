package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PosterManagerTest {

    @Test
    public void shouldAddAndFindAll() {
        PosterManager manager = new PosterManager();
        manager.add("Film 1");
        manager.add("Film 2");

        String[] expected = {"Film 1", "Film 2"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    public void shouldReturnLastFiveByDefault() {
        PosterManager manager = new PosterManager();
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");

        String[] expected = {"Film 6", "Film 5", "Film 4", "Film 3", "Film 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldReturnLastThreeWithCustomLimit() {
        PosterManager manager = new PosterManager(3);
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");

        String[] expected = {"Film 4", "Film 3", "Film 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldReturnAllIfLessThanLimit() {
        PosterManager manager = new PosterManager(10);
        manager.add("Film 1");
        manager.add("Film 2");

        String[] expected = {"Film 2", "Film 1"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    public void shouldReturnEmptyWhenNothingAdded() {
        PosterManager manager = new PosterManager();
        assertArrayEquals(new String[0], manager.findAll());
        assertArrayEquals(new String[0], manager.findLast());
    }
}
