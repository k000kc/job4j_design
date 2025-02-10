package ru.job4j.ood.lsp;

public class CreditAccount implements Account {
    private double balance;
    private double creditFacilities;

    public CreditAccount(double balance) {
        this.balance = balance;
        this.creditFacilities = 2 * balance;
    }

    /**
     * нарушение lsp. усиление постусловия, в данной реализации может быть списанно
     * средств больше чем находится на балансе.
     */
    @Override
    public boolean withdrawBalance(double amount) {
        if (amount > balance + creditFacilities) {
            throw new IllegalArgumentException("incorrect amount entered");
        }
        balance = balance - amount;
        return true;
    }
}
