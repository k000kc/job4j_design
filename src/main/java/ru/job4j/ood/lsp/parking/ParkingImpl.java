package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingImpl implements Parking {
    private List<ParkingSpace> spaces;
    private int carSpaceCount;
    private int truckSpaceCount;

    public ParkingImpl(int carSpaceCount, int truckSpaceCount) {
        spaces = new ArrayList<>();
        this.carSpaceCount = carSpaceCount;
        this.truckSpaceCount = truckSpaceCount;
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return true;
    }

    @Override
    public List<ParkingSpace> getParkingSpaces() {
        return spaces;
    }
}
