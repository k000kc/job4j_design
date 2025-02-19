package ru.job4j.ood.lsp.foodstore;

import java.util.List;

public interface Store {
    boolean add(Food food);
    List<Food> getAllFoods();
    boolean isDelivery(Food food);
}
