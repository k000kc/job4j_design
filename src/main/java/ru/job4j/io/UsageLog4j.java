package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");

        String name = "Andrey Petrov";
        byte age = 35;
        char gender = 'M';
        float height = 170.5F;
        short numBricks = 25000;
        int number = 57;
        double spaceDistance = 1.432E+12;
        boolean isError = false;
        long fileSize = 4096L;
        LOG.debug("User info name: {}, age: {}, gender: {}, height: {}F", name, age, gender, height);
        LOG.debug("number of bricks: {}, number: {}, space distance: {}", numBricks, number, spaceDistance);
        LOG.debug("the presence of an error: {}, file size: {}L", isError, fileSize);

        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
