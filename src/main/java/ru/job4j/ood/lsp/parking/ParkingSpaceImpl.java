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
        if (occupied) {
            throw new IllegalStateException("This space is occupied!");
        }
        this.vehicle = vehicle;
        this.occupied = true;
    }

    @Override
    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public int parkingSize() {
        return size;
    }
}
