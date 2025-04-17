package ru.job4j.ood.logger;

public class LogFormatting implements Formatting {
    @Override
    public String format(Level level, String message) {
        return String.format("[%s]: %s", level, message);
    }
}
