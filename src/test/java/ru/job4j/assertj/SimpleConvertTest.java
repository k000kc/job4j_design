package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkArrayFiltered() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).filteredOn(word -> word.startsWith("fi"))
                .hasSize(2)
                .isEqualTo(new String[] {"first", "five"});
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).contains("three")
                .hasSize(5)
                .doesNotContain("six", "zero")
                .containsSequence("second", "three")
                .anySatisfy(word ->
                    assertThat(word.length()).isEqualTo(6))
                .filteredOn(word -> word.endsWith("e"))
                .hasSize(2)
                .last().isEqualTo("five");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).contains("three")
                .hasSize(5)
                .doesNotContain("six", "zero")
                .containsAnyOf("second", "zero")
                .allMatch(word -> word.length() > 3)
                .filteredOn(word -> word.endsWith("e"))
                .hasSize(2)
                .last().isEqualTo("five");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("zero", "first", "second", "three", "four");
        assertThat(map).containsValue(3)
                .containsKey("first")
                .containsEntry("zero", 0)
                .hasSize(5);
    }
}