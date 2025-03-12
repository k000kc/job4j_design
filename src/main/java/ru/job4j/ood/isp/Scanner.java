package ru.job4j.ood.isp;

public class Scanner implements Device {
    @Override
    public void print(String text) {
        throw new UnsupportedOperationException("Print is not supported!");
    }

    @Override
    public void fax(String text) {
        throw new UnsupportedOperationException("Fax is not supported!");
    }

    @Override
    public void scan(String path) {
        System.out.println(path);
    }
}
