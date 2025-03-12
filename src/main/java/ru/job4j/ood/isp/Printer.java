package ru.job4j.ood.isp;

public class Printer implements Device {
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void fax(String text) {
        throw new UnsupportedOperationException("Fax is not supported!");
    }

    @Override
    public void scan(String path) {
        throw new UnsupportedOperationException("Scan is not supported!");
    }
}
