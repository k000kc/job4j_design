package ru.job4j.ood.logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("logger.properties");
        logger.log(Level.WARN, "this is log");
    }
}
