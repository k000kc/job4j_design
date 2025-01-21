package ru.job4j.ood.srp;

public class User {
    private final String login;
    private final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    /**
     * нарушение принципа SRP. Авторизацию лучше вынести в отдельный класс
     * в данном классе оставить только представление объекта User
     */
    public boolean authorization(User user) {
        boolean res = false;
        if (user.login.equals(login) && user.password.equals(password)) {
            res = true;
        }
        return res;
    }
}
