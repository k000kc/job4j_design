package ru.job4j.ood.logger;

public class FileAppender implements Appender {

    private final Level level;

    public FileAppender(Level level) {
        this.level = level;
    }

    @Override
    public void append(String message) {
        System.out.println("Write to file: " + message);
    }
}
