package ru.job4j.collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {
    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 7));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(6).containsSequence(1, 2, 3, 4, 5, 7);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 5, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(6).containsSequence(1, 2, 3, 4, 5, 7);
    }

    @Test
    void whenRemoveIfValueLessThenThree() {
        ListUtils.addBefore(input, 1, 2);
        ListUtils.removeIf(input, x -> x <= 3);
        assertThat(input).containsSequence(4, 5, 7);
    }

    @Test
    void whenReplaceIfValueLessThenThree() {
        ListUtils.addBefore(input, 1, 2);
        ListUtils.replaceIf(input, x -> x <= 3, 4);
        assertThat(input).containsSequence(4, 4, 4, 4, 5, 7);
    }

    @Test
    void whenRemoveListElements() {
        ListUtils.removeAll(input, Arrays.asList(1, 7));
        assertThat(input).containsSequence(3, 4, 5);
    }
}