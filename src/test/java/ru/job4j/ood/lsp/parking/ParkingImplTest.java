package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParkingImplTest {
    @Test
    public void whenAddVehicleToParkingThenParkingContainsOccupiedSpaceThisVehikle() {
        Vehicle vehicle = new Car(1, "a234bc21");
        ParkingSpace space = new ParkingSpaceImpl(1);
        Parking parking = new ParkingImpl(1, 1);
        parking.addVehicle(vehicle);
        assertThat(parking.getParkingSpaces()).contains(space);
    }

    @Test
    public void whenInitParkingCarSpaceCount1AndTrackSpaceCount1ThenReturnSizeParking2() {
        Parking parking = new ParkingImpl(1, 1);
        assertThat(parking.getParkingSpaces().size()).isEqualTo(2);
    }
}