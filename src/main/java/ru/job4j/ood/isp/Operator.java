package ru.job4j.ood.isp;

public class Operator implements User {
    @Override
    public String addUser(String name, String password) {
        throw new UnsupportedOperationException("Access denied!");
    }

    @Override
    public boolean deleteUser(String name) {
        throw new UnsupportedOperationException("Access denied!");
    }

    @Override
    public boolean changePassword(String name, String newPassword) {
        throw new UnsupportedOperationException("Access denied!");
    }

    @Override
    public String getUser(String name) {
        return name;
    }
}
