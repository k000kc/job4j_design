package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {
    boolean addVehicle(Vehicle vehicle);
    List<ParkingSpace> getParkingSpace();
}
