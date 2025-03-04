package ru.job4j.ood.lsp.parking;

public class Car implements Vehicle {
    private int size;
    private String number;

    public Car(int size, String number) {
        this.size = size;
        this.number = number;
    }

    @Override
    public int vehicleSize() {
        return 0;
    }

    @Override
    public String numberVehicle() {
        return null;
    }
}
