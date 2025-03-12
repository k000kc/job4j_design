package ru.job4j.ood.isp;

public class Admin implements User {
    @Override
    public String addUser(String name, String password) {
        return name;
    }

    @Override
    public boolean deleteUser(String name) {
        return true;
    }

    @Override
    public boolean changePassword(String name, String newPassword) {
        return true;
    }

    @Override
    public String getUser(String name) {
        return name;
    }
}
