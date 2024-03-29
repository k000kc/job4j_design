package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path s : sources) {
                zip.putNextEntry(new ZipEntry(s.toFile().getPath()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(s.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkArgs(String[] args, ArgsName argsName) {
        if (args.length < 3) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        if (Arrays.stream(args).noneMatch(arg -> arg.startsWith("-d"))) {
            throw new IllegalArgumentException("specify the directory using the -d key");
        }
        if (Arrays.stream(args).noneMatch(arg -> arg.startsWith("-e"))) {
            throw new IllegalArgumentException("specify the file extension to exclude using the -e key");
        }
        if (Arrays.stream(args).noneMatch(arg -> arg.startsWith("-o"))) {
            throw new IllegalArgumentException("specify the output file name using the -o key");
        }
        Path directory = Paths.get(argsName.get("d"));
        if (!Files.exists(directory)) {
            throw new IllegalArgumentException(String.format("%s - not exist", directory));
        }
        if (!argsName.get("e").startsWith(".")) {
            throw new IllegalArgumentException("the file extension must start with the \".\" character");
        }
        if (!argsName.get("o").endsWith(".zip")) {
            throw new IllegalArgumentException("the name of the output file must end with \".zip\"");
        }
    }

    private static void run(String[] args) throws IOException {
        Zip zip = new Zip();
        ArgsName argsName = ArgsName.of(args);
        checkArgs(args, argsName);
        Path directory = Paths.get(argsName.get("d"));
        Predicate<Path> exclude = p -> !p.toFile().getName().endsWith(argsName.get("e"));
        File output = new File(argsName.get("o"));
        zip.packFiles(Search.search(directory, exclude), output);
    }

    public static void main(String[] args) {
        try {
            run(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
