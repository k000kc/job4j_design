package ru.job4j.ood.isp;

/**
 * Интерфейс нарушает принцип ISP, так как вынуждает реализовать все методы,
 * у некоторых реализаций которого не должно быть всех прав на изменение данных пользователя.
 */
public interface User {
    String addUser(String name, String password);
    boolean deleteUser(String name);
    boolean changePassword(String name, String newPassword);
    String getUser(String name);
}
