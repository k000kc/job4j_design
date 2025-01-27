package ru.job4j.ood.ocp;

public class ProductCreator {
    /**
     * нарушение ocp, для каждого типа создаваемого продукта придется изменять метод.
     * Можно воспользоваться паттерном "Фабричный метод",
     * создать интерфейс ProductFactory с методом create(Strring name)
     * и классы реализующие данный интерфейс для каждого конкретного типа продукта.
     * После в классе ProductCreator добавить поле ProductFactory, и конструктор
     * принимающий в качестве аргумента объект ProductFactory.
     */
    public Product create(String type, String name) {
        /*
         * логика создания продукта.
         */
        return new Product(type, name);
    }

    private class Product {
        String type;
        String name;

        public Product(String type, String name) {
            this.type = type;
            this.name = name;
        }
    }
}
