package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), visitor);
        printDuplicates(visitor);
    }

    public static void printDuplicates(DuplicatesVisitor visitor) {
        visitor.getFiles().forEach((k, v) -> {
            if (v.size() > 1) {
                System.out.printf("%s - %d byte\n", k.getName(), k.getSize());
                v.forEach(System.out::println);
            }
        });
    }
}
