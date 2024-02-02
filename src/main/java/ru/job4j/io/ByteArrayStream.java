package ru.job4j.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStream {
    public static void main(String[] args) {
        byte[] bytes = new byte[] {'J', 'a', 'v', 'a'};
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        int data;
        while ((data = stream.read()) != -1) {
            System.out.print((char) data);
        }
        System.out.println();
        String str = "123456789";
        byte[] bytes1 = str.getBytes();
        ByteArrayInputStream stream1 = new ByteArrayInputStream(bytes1, 3, 4);
        int data1;
        while ((data1 = stream1.read()) != -1) {
            System.out.println((char) data1);
        }
        System.out.println();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] bytes2 = "Message".getBytes();
        outSteam.writeBytes(bytes2);
        System.out.println(outSteam);
        byte[] byteArray = outSteam.toByteArray();
        for (byte ch : byteArray) {
            System.out.print((char) ch);
        }
        try (FileOutputStream fileStream = new FileOutputStream("data/message.txt")) {
            outSteam.writeTo(fileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
