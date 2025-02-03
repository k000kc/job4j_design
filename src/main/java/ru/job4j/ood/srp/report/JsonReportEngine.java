package ru.job4j.ood.srp.report;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.function.Predicate;

public class JsonReportEngine implements Report {

    private final Store store;

    public JsonReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        JsonArray array = new JsonArray();
        for (Employee e : store.findBy(filter)) {
            JsonObject object = new JsonObject();
            object.addProperty("name", e.getName());
            object.addProperty("hired", new ReportDateTimeParser().parse(e.getHired()));
            object.addProperty("fired", new ReportDateTimeParser().parse(e.getFired()));
            object.addProperty("salary", e.getSalary());
            array.add(object);
        }
        return array.toString();
    }
}
