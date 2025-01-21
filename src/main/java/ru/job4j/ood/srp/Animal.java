package ru.job4j.ood.srp;

public class Animal {
    private final String name;
    private final String type;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    /**
     * Нарушение SRP. метод лучше вынести в отдельный интерфейс
     * и сделать реализацию для каждого типа животного отдельно
     */
    public void move(Animal animal) {
        if (animal.getType().equals("fish")) {
            System.out.println("Swimming");
        } else if (animal.getType().equals("bird")) {
            System.out.println("Flying");
        } else {
            System.out.println("Runing");
        }
    }
}
