package ru.job4j.ood.lsp;

public class PositiveThermometer extends Thermometer {
    /**
     * нарушение lsp. Если в качестве аргумента будем передовать объект типа Thermometer,
     * может вылететь исключение если в аргументе передадут PositiveThermometer в случае
     * если инициализирован будет отрицательной переменной
     *
     */
    public PositiveThermometer(double temperarure) {
        super(temperarure);
        if (temperarure < 0) {
            throw new IllegalArgumentException("The temperature should be above zero");
        }
    }
}
