package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder or extension file is null. Usage  ROOT_FOLDER and EXTENSION_FILE.");
        }
        Path start = Paths.get(args[0]);
        String extensionFile = args[1];
        isValid(start, extensionFile);
        search(start, path -> path.toFile().getName().endsWith(extensionFile)).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    private static void isValid(Path dir, String extension) {
        if (!Files.exists(dir)) {
            throw new IllegalArgumentException(String.format("Not exist %s", dir.toAbsolutePath()));
        }
        if (!Files.isDirectory(dir)) {
            throw new IllegalArgumentException(String.format("Not directory %s", dir.toAbsolutePath()));
        }

        if (!extension.startsWith(".")) {
            throw new IllegalArgumentException("the file extension must start with \".\"");
        }
    }
}
