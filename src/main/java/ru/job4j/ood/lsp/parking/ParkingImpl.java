package ru.job4j.ood.lsp.parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingImpl implements Parking {
    private List<ParkingSpace> spaces;
    private int carSpaceCount;
    private int truckSpaceCount;

    public ParkingImpl(int carSpaceCount, int truckSpaceCount) {
        this.carSpaceCount = carSpaceCount;
        this.truckSpaceCount = truckSpaceCount;
        this.spaces = new ArrayList<>();
        init();
    }

    private void init() {
        for (int i = 0; i < carSpaceCount; i++) {
            spaces.add(new ParkingSpaceImpl(1));
        }
        for (int i = 0; i < truckSpaceCount; i++) {
            spaces.add(new ParkingSpaceImpl(3));
        }
    }

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        boolean result = false;
        if (vehicle.vehicleSize() == 1) {
            for (ParkingSpace space : spaces) {
                if (!space.isOccupied() && space.parkingSize() == 1) {
                    space.occupy(vehicle);
                    result = true;
                    break;
                }
            }
        }
        if (vehicle.vehicleSize() > 1) {
            for (ParkingSpace space : spaces) {
                if (!space.isOccupied() && space.parkingSize() > 1) {
                    space.occupy(vehicle);
                    result = true;
                    break;
                }
            }
        }
        if (!result) {
            List<Integer> availableSpace = IntStream.range(0, spaces.size())
                    .filter(i -> !spaces.get(i).isOccupied() && spaces.get(i).parkingSize() == 1)
                    .boxed()
                    .toList();
            if (availableSpace.size() >= vehicle.vehicleSize()) {
                for (int i = 0; i <= availableSpace.size() - vehicle.vehicleSize(); i++) {
                    boolean isConsistent = true;
                    for (int j = 1; j < vehicle.vehicleSize(); j++) {
                        if (availableSpace.get(i + j) != availableSpace.get(i) + j) {
                            isConsistent = false;
                            break;
                        }
                    }
                    if (isConsistent) {
                        for (int j = 0; j < vehicle.vehicleSize(); j++) {
                            spaces.get(availableSpace.get(i + j)).occupy(vehicle);
                        }
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<ParkingSpace> getParkingSpaces() {
        return spaces.stream().filter(ParkingSpace::isOccupied).toList();
    }
}
