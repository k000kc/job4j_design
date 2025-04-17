package ru.job4j.ood.logger;

public class FileAppender implements Appender {
    @Override
    public void append(String message) {
        System.out.println("Write to file: " + message);
    }
}
