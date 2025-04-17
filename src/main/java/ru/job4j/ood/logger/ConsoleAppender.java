package ru.job4j.ood.logger;

public class ConsoleAppender implements Appender {
    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
