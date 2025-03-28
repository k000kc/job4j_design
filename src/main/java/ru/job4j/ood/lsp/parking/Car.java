package ru.job4j.ood.lsp.parking;

public class Car implements Vehicle {
    private int size;
    private String number;

    public Car(String number) {
        this.size = 1;
        this.number = number;
    }

    @Override
    public int vehicleSize() {
        return size;
    }

    @Override
    public String numberVehicle() {
        return number;
    }
}
