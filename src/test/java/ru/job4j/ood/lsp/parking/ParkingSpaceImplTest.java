package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ParkingSpaceImplTest {

    @Test
    public void whenAddVehicleThenReturnTrue() {
        Vehicle vehicle = new Car("а345вс21");
        ParkingSpace space = new ParkingSpaceImpl(1);
        space.occupy(vehicle);
        assertThat(space.isOccupied()).isTrue();
    }
}