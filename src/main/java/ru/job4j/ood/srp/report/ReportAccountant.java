package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class ReportAccountant implements Report {

    private final Store store;
    private final Currency sourceCurrency;
    private final Currency targetCurrency;
    private final CurrencyConverter converter;


    public ReportAccountant(Store store, Currency sourceCurrency, Currency targetCurrency, CurrencyConverter converter) {
        this.store = store;
        this.sourceCurrency = sourceCurrency;
        this.targetCurrency = targetCurrency;
        this.converter = converter;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(": ")
                    .append(employee.getSalary()).append(" ")
                    .append(sourceCurrency).append(" = ")
                    .append(converter.convert(sourceCurrency, employee.getSalary(), targetCurrency)).append(" ")
                    .append(targetCurrency).append(System.lineSeparator());
        }
        System.out.println(text);
        return text.toString();
    }
}
