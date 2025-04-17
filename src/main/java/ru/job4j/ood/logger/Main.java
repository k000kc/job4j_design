package ru.job4j.ood.logger;

public class Main {
    public static void main(String[] args) {
        Formatting formatting = new LogFormatting();
        Appender appender = new ConsoleAppender();
        Logger logger = new Logger(formatting, appender, Level.INFO);
        logger.log("Test information");
    }
}
