package ru.job4j.ood.logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class LoggerFactory {
    public static Logger getLogger(String pathProperties) {
        Properties properties = new Properties();
        try (InputStream in = LoggerFactory.class.getClassLoader().getResourceAsStream(pathProperties)) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Appender> appenders = getAppenders(properties);
        return new Logger(new LogFormatting(), appenders);
    }

    private static List<Appender> getAppenders(Properties properties) {
        Map<String, Appender> appenderMap = new HashMap<>();

        for (String key : properties.stringPropertyNames()) {
            if (key.startsWith("logger.appender.")) {
                String[] parts = key.split("\\.");
                String appenderName = parts[2];
                if (!appenderMap.containsKey(appenderName)) {
                    String appenderType = properties.getProperty("logger.appender." + appenderName);
                    String levelString = properties.getProperty("logger.appender." + appenderName + ".level");
                    Level level = Level.valueOf(levelString);
                    switch (appenderType) {
                        case "ConsoleAppender":
                            appenderMap.put(appenderName, new ConsoleAppender(level));
                            break;
                        case "FileAppender":
                            appenderMap.put(appenderName, new FileAppender(level));
                            break;
                        default:
                            System.err.println("Unknown appender type: " + appenderType);
                            break;
                    }
                }
            }
        }
        return new ArrayList<>(appenderMap.values());
    }
 }
