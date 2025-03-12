package ru.job4j.ood.isp;

public class Warrior implements Unit {
    @Override
    public void fighting() {
        System.out.println("I kick and I bite.");
    }

    @Override
    public void shooting() {
        throw new UnsupportedOperationException("Shooting is not supported!");
    }

    @Override
    public void spells() {
        throw new UnsupportedOperationException("Spells is not supported!");
    }
}
