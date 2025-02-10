package ru.job4j.ood.lsp;

public class BankAccount implements Account {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public boolean withdrawBalance(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("incorrect amount entered");
        }
        balance = balance - amount;
        return true;
    }
}
