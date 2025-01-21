package ru.job4j.ood.srp;

public class Rectangle {
    private final int hight;
    private final int weight;

    public Rectangle(int hight, int weight) {
        this.hight = hight;
        this.weight = weight;
    }

    public int getHight() {
        return hight;
    }

    public int getWeight() {
        return weight;
    }

    /**
     * Нарушение SRP. Подсчет площади фигуры лучше вывести в отдельный клас
     * в текущем классе нужно оставить только представление прямоугольника
     */
    public int area(Rectangle rectangle) {
        return rectangle.getHight() * rectangle.getWeight();
    }
}
