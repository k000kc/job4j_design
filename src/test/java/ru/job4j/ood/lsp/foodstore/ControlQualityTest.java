package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    public void whenAddFoodsThenAreDistributedAcrossTheStorages() {
        List<Store> storeList = new ArrayList<>();
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();

        storeList.add(warehouse);
        storeList.add(shop);
        storeList.add(trash);

        ControlQuality controlQuality = new ControlQuality(storeList);
        Calendar today = Calendar.getInstance();

        Calendar appleCreate = (Calendar) today.clone();
        appleCreate.add(Calendar.DAY_OF_MONTH, - 1);
        Calendar appleExpiry = (Calendar) today.clone();
        appleExpiry.add(Calendar.DAY_OF_MONTH, 5);
        Food apple = new Food("Яблоко", appleExpiry.getTime(), appleCreate.getTime(), 50.0);

        Calendar milkCreate = (Calendar) today.clone();
        milkCreate.add(Calendar.DAY_OF_MONTH, -5);
        Calendar milkExpiry = (Calendar) today.clone();
        milkExpiry.add(Calendar.DAY_OF_MONTH, -1);
        Food milk = new Food("Молоко", milkExpiry.getTime(), milkCreate.getTime(), 80.0);

        Calendar breadCreate = (Calendar) today.clone();
        breadCreate.add(Calendar.DAY_OF_MONTH, - 7);
        Calendar breadExpiry = (Calendar) today.clone();
        breadExpiry.add(Calendar.DAY_OF_MONTH, 5);
        Food bread = new Food("Хлеб", breadExpiry.getTime(), breadCreate.getTime(), 30.0);

        controlQuality.distribution(apple);
        controlQuality.distribution(milk);
        controlQuality.distribution(bread);

        assertThat(warehouse.getAllFoods()).contains(apple);
        assertThat(trash.getAllFoods()).contains(milk);
        assertThat(shop.getAllFoods()).contains(bread);
    }
}