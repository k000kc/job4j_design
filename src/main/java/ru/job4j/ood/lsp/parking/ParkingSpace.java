package ru.job4j.ood.lsp.parking;

public interface ParkingSpace {
    void occupy(Vehicle vehicle);
    boolean isOccupied();
    int parkingSize();

}
