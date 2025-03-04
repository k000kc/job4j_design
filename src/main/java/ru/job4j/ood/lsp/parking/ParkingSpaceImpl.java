package ru.job4j.ood.lsp.parking;

public class ParkingSpaceImpl implements ParkingSpace {
    private int size;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpaceImpl(int size) {
        this.size = size;
    }

    @Override
    public void occupy(Vehicle vehicle) {
    }

    @Override
    public boolean isOccupied() {
        return false;
    }

    @Override
    public int parkingSize() {
        return size;
    }
}
