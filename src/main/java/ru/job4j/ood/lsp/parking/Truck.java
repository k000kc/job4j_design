package ru.job4j.ood.lsp.parking;

public class Truck implements Vehicle {

    private int size;
    private String number;

    public Truck(int size, String number) {
        this.size = size;
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
