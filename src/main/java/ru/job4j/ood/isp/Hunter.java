package ru.job4j.ood.isp;

public class Hunter implements Unit {
    @Override
    public void fighting() {
        throw new UnsupportedOperationException("Fighting is not supported!");
    }

    @Override
    public void shooting() {
        System.out.println("I'm shooting");
    }

    @Override
    public void spells() {
        throw new UnsupportedOperationException("Spells is not supported!");
    }
}
