package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private final String path;
    private final Map<String, String> values;

    public Config(String path) {
        this.path = path;
        this.values = new HashMap<>();
        load();
    }

    private void load() {
        String[] strArray;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty() || !line.startsWith("#")) {
                    strArray = line.split("=", 2);
                    if (strArray.length < 2 || strArray[0].isEmpty()) {
                        throw new IllegalArgumentException("Invalid line format: " + line);
                    }
                    values.put(strArray[0], strArray[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return values.get(key);
    }
}
