package ru.job4j.ood.logger;

public class ConsoleAppender implements Appender {

    private final Level level;

    public ConsoleAppender(Level level) {
        this.level = level;
    }

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
