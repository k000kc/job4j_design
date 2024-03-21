package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CSVReader {

    public static void handle(ArgsName argsName) {
        CSVReader reader = new CSVReader();
        List<String> out = reader.getFiteredData(argsName);
        if (Objects.equals("stdout", argsName.get("out"))) {
            out.forEach(System.out::println);
        } else {
            try (FileWriter writer = new FileWriter(argsName.get("out"))) {
                for (String s : out) {
                    writer.write(s + System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> getLines(ArgsName argsName) {
        List<String> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(argsName.get("path"))).useDelimiter(System.lineSeparator())) {
            while (scanner.hasNext()) {
                result.add(scanner.next().replaceAll("\"", ""));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private List<Integer> getFilteredIndex(ArgsName argsName) {
        List<String> filters = List.of(argsName.get("filter").split(","));
        List<String> head = List.of(getLines(argsName).get(0).split(argsName.get("delimiter")));
        List<Integer> index = new ArrayList<>();
        int i;
        for (String data : filters) {
            i = head.indexOf(data);
            if (i != -1) {
                index.add(i);
            }
        }
        return index;
    }

    private List<String> getFiteredData(ArgsName argsName) {
        List<String> result = new ArrayList<>();
        List<String> lines = getLines(argsName);
        List<String> tail;
        for (String line : lines) {
            StringBuilder builder = new StringBuilder();
            tail = List.of(line.split(argsName.get("delimiter")));
            for (Integer index : getFilteredIndex(argsName)) {
                builder.append(String.format("%s%s", tail.get(index), argsName.get("delimiter")));
            }
            result.add(builder.toString().replaceAll(".$", ""));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
