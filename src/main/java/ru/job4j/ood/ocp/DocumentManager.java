package ru.job4j.ood.ocp;

public class DocumentManager {

    /**нарушение ocp. для каждого расширения документа необходима своя обработка.
     * Для исправление потребуется создать интерфейс Document c методом process()
     * и реализовать этот интерфейс для каждого расширения документа.
     * в качестве аргумента в метод processing класса DocumentManager нужно передать
     * объект типа Document.
     */
    public boolean processing(String format, String name) {
        if (format.equals("txt")) {
            System.out.println("это документ txt");
            //логика обработки документа...
        }
        return true;
    }
}
