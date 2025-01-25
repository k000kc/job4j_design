package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.CurrencyConverter;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportAccountantTest {

    @Test
    public void whenSalaryTransferredToAnotherCurrency() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 1000);
        store.add(worker);
        CurrencyConverter converter = new InMemoryCurrencyConverter();
        converter.convert(Currency.RUB, worker.getSalary(), Currency.EUR);
        Report report = new ReportAccountant(store,Currency.RUB, Currency.EUR, converter);
        String expected = "Ivan: 1000.0 RUB = 16.6 EUR" +
                System.lineSeparator();
        assertThat(report.generate(e -> true)).isEqualTo(expected);
    }
}