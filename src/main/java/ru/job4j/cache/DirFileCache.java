package ru.job4j.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path path = Paths.get(cachingDir, key);
        try {
            return Files.readString(path);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
