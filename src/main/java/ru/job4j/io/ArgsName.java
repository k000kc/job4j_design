package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        this.chekKey(key);
        return values.get(key);
    }

    private void chekKey(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
    }

    private void chekArgs(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        Arrays.stream(args).forEach(str -> {
            if (!str.startsWith("-")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", str));
            }
            if (str.startsWith("-=")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a key", str));
            }
            if (!str.contains("=")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", str));
            }
            if (str.split("=", 2)[1].isEmpty()) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", str));
            }
        });
    }

    private void parse(String[] args) {
        String[] argsArray;
        for (String arg : args) {
            argsArray = arg.split("=", 2);
            if (argsArray[0].startsWith("-")) {
                this.values.put(argsArray[0].substring(1), argsArray[1]);
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.chekArgs(args);
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
