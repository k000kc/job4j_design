package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConfigTest {
    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenExistNullString() {
        String path = "./data/exist_null_string.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    public void whenNotValueThenExeption() {
        String path = "./data/error_patern1.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).isEqualTo("Error Pattern");
    }

    @Test
    public void whenNotKeyThenExeption() {
        String path = "./data/error_patern2.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).isEqualTo("Error Pattern");
    }

    @Test
    public void whenNotKeyAndValueThenExeption() {
        String path = "./data/error_patern3.properties";
        Config config = new Config(path);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class, config::load);
        assertThat(exception.getMessage()).isEqualTo("Error Pattern");
    }
}