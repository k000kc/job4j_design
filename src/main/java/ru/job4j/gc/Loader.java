package ru.job4j.gc;

public class Loader {
    public static void main(String[] args) throws ClassNotFoundException {
        Class loader = Loader.class;
        System.out.println("Класс переменной loader: " + loader);
        System.out.println("Загрузчик класса переменной loader:  " + loader.getClassLoader());

        Class string = String.class;
        System.out.println("Класс переменной loader: " + string);
        System.out.println("Загрузчик класса переменной string:  " + string.getClassLoader());
    }
}
