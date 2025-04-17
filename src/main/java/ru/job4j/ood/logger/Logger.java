package ru.job4j.ood.logger;

public class Logger {
    private final Formatting formatting;
    private final Appender appender;
    private final Level level;

    public Logger(Formatting formatting, Appender appender, Level level) {
        this.formatting = formatting;
        this.appender = appender;
        this.level = level;
    }

    public void log(String message) {
        String formatted = formatting.format(level, message);
        appender.append(formatted);
    }
}
