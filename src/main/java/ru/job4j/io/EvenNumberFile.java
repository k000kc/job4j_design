package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            StringBuilder number = new StringBuilder();
            int read;
            while ((read = input.read()) != -1) {
                number.append((char) read);
            }
            String[] lines = number.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line + " - " + (Integer.parseInt(line) % 2 == 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
