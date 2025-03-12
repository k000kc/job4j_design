package ru.job4j.ood.isp;

public class Mfu implements Device {
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void fax(String text) {
        System.out.println(text);
    }

    @Override
    public void scan(String path) {
        System.out.println(path);
    }
}
