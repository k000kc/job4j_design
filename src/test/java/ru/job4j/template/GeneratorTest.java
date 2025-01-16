package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
@Disabled("Тесты отключены. Удалить аннотацию после реализации всех методов по заданию.")
class GeneratorTest {

    @Test
    public void whenInsertValueIntoTamplateThenGetResultString() {
        Generator generator = new GeneratorUsers();
        Map<String, String > args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        String expected = "I am a Petr Arsentev, Who are you?";
        assertThat(expected).isEqualTo(generator.produce(template, args));
    }

    @Test
    public void whenInTamplateExtraKeyThenThrownExeption() {
        Generator generator = new GeneratorUsers();
        Map<String, String > args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        String template = "I am a ${name}, Who are ${subject}?";
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenThen() {
        Generator generator = new GeneratorUsers();
        Map<String, String > args = new HashMap<>();
        args.put("name", "Petr");
        args.put("lastname", "Arsentev");
        args.put("subject", "you");
        String template = "I am a ${name}, Who are ${subject}?";
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}