package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParkingImplTest {
    @Test
    public void whenAddVehicleToParkingThenParkingSpaceOccupieted() {
        Parking parking = new ParkingImpl(1, 0);
        Vehicle car = new Car("car123");
        parking.addVehicle(car);
        assertThat(1).isEqualTo(parking.getParkingSpaces().size());
    }

    @Test
    public void whenAdd2TrucksButNotSpacesForTruckThenTruckTakesSpaceForCars() {
        Parking parking = new ParkingImpl(7, 0);
        Vehicle truck1 = new Truck(2, "truck-1");
        Vehicle truck2 = new Truck(3, "truck-2");
        parking.addVehicle(truck1);
        parking.addVehicle(truck2);
        assertThat(5).isEqualTo(parking.getParkingSpaces().size());
    }
}