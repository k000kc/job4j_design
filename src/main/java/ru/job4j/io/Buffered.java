package ru.job4j.io;

import java.io.*;

public class Buffered {
    public static void main(String[] args) {
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("data/input.txt"));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("data/output.txt"))) {
            output.write(input.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("data/newData.txt"));
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("data/output.txt", true))) {
            output.write(input.readAllBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("data/newData.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/output.txt", true))) {
            writer.write(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
