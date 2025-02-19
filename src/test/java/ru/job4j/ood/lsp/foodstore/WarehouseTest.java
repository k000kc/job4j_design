package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {
    @Test
    public void whenFoodWasProducedRecentlyThenReturnTrue() {
        Store warehouse = new Warehouse();
        Calendar today = Calendar.getInstance();
        Calendar breadCreate = (Calendar) today.clone();
        breadCreate.add(Calendar.DAY_OF_MONTH, -1);
        Calendar breadExpiry = (Calendar) today.clone();
        breadExpiry.add(Calendar.DAY_OF_MONTH, 5);
        Food bread = new Food("Хлеб", breadExpiry.getTime(), breadCreate.getTime(), 30.0);
        assertThat(warehouse.isDelivery(bread)).isTrue();
    }
}