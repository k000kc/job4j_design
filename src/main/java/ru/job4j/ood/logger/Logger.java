package ru.job4j.ood.logger;

import java.util.List;

public class Logger {
    private final Formatting formatting;
    private final List<Appender> appenders;

    public Logger(Formatting formatting, List<Appender> appenders) {
        this.formatting = formatting;
        this.appenders = appenders;
    }

    public void log(Level level, String message) {
        String formatted = formatting.format(level, message);
        for (Appender appender : appenders) {
            appender.append(formatted);
        }
    }
}
