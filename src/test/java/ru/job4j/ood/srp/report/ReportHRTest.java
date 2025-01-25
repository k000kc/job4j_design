package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportHRTest {
    @Test
    public void whenThen() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Egor", now, now, 100);
        Employee worker3 = new Employee("Anton", now, now, 100);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report report = new ReportHR(store);
        String exected = worker3.getName() + System.lineSeparator()
                + worker2.getName() + System.lineSeparator()
                + worker1.getName();
        assertThat(report.generate(e -> true)).isEqualTo(exected);
    }

}