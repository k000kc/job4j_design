package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        String[] strArray;
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            for (String str : reader.lines().toList()) {
                if (!str.isEmpty() && !str.startsWith("#")) {
                    strArray = str.split("=");
                    if (strArray.length < 2 || strArray[0].isEmpty()) {
                        throw new IllegalArgumentException("Error Pattern");
                    }
                    String key = strArray[0];
                    String value = strArray[1];
                    values.put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(new FileReader(this.path))) {
            reader.lines().forEach(output::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Config("data/app.properties"));
        new Config("data/error_patern2.properties");
    }
}
