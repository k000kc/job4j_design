package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintUsage {
    public static void main(String[] args) {
        try (PrintStream stream = new PrintStream(new FileOutputStream("data/print.txt"));
             PrintWriter writer = new PrintWriter("data/write.txt")) {
            stream.println("Из PrintStream в FileOutputStream");
            stream.write("новыя строка".getBytes());
            writer.println("новыя строка");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintStream stream = new PrintStream("data/print1.txt")) {
            stream.println("new string");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
