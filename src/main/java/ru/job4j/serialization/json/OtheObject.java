package ru.job4j.serialization.json;

public class OtheObject {
    private int value;
    private String name;

    public OtheObject(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "OtheObject{"
                + "value=" + value
                + ", name='" + name + '\''
                + '}';
    }
}
