package ru.job4j.ood.isp;

/**
 * Интерфейс нарушает принцип ISP, так как вынуждает реализовать все методы,
 * реализации которого не могут поддерживать весь функционал.
 */
public interface Device {
    void print(String text);
    void fax(String text);
    void scan(String path);
}

