package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ControlQuality {
    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void distribution(Food food) {
        for (Store store : stores) {
            if (store.isDelivery(food)) {
                store.add(food);
            }
        }
    }

    public static void main(String[] args) {
        List<Store> storeList = new ArrayList<>();
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();

        storeList.add(warehouse);
        storeList.add(shop);
        storeList.add(trash);

        ControlQuality controlQuality = new ControlQuality(storeList);

        Calendar appleExpiry = new GregorianCalendar(2025, Calendar.FEBRUARY, 27);
        Calendar appleCreate = new GregorianCalendar(2025, Calendar.JANUARY, 25);
        Food apple = new Food("Яблоко", appleExpiry.getTime(), appleCreate.getTime(), 50.0);

        Calendar milkExpiry = new GregorianCalendar(2025, Calendar.FEBRUARY, 28);
        Calendar milkCreate = new GregorianCalendar(2025, Calendar.FEBRUARY, 16);
        Food milk = new Food("Молоко", milkExpiry.getTime(), milkCreate.getTime(), 80.0);

        Calendar breadExpiry = new GregorianCalendar(2025, Calendar.JANUARY, 14);
        Calendar breadCreate = new GregorianCalendar(2025, Calendar.JANUARY, 9);
        Food bread = new Food("Хлеб", breadExpiry.getTime(), breadCreate.getTime(), 30.0);

        Calendar eggExpiry = new GregorianCalendar(2025, Calendar.FEBRUARY, 18);
        Calendar eggCreate = new GregorianCalendar(2025, Calendar.FEBRUARY, 1);
        Food egg = new Food("Яйца", eggExpiry.getTime(), eggCreate.getTime(), 130.0);

        controlQuality.distribution(apple);
        controlQuality.distribution(milk);
        controlQuality.distribution(bread);
        controlQuality.distribution(egg);

        System.out.println(warehouse.getAllFoods() + "- warehouse \n");
        System.out.println(shop.getAllFoods() + "- shop \n");
        System.out.println(trash.getAllFoods() + "- trash \n");
    }
}
