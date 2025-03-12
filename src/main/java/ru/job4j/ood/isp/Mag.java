package ru.job4j.ood.isp;

public class Mag implements Unit {
    @Override
    public void fighting() {
        throw new UnsupportedOperationException("Fighting is not supported!");
    }

    @Override
    public void shooting() {
        throw new UnsupportedOperationException("Shooting is not supported!");
    }

    @Override
    public void spells() {
        System.out.println("Trah-Tibidoh");
    }
}
