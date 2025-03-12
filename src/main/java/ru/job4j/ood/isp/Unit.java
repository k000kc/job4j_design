package ru.job4j.ood.isp;

/**
 * Интерфейс нарушает принцип ISP, так как вынуждает реализовать все методы,
 * реализации которого не соответствуют умениям игровых объектов.
 */
public interface Unit {
    void fighting();
    void shooting();
    void spells();
}
