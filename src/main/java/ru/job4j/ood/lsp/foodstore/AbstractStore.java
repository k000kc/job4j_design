package ru.job4j.ood.lsp.foodstore;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private List<Food> foods = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        return foods.add(food);
    }

    @Override
    public List<Food> getAllFoods() {
        return foods;
    }

    public double getFreshness(Food food) {
        long expireDate = food.getExpiryDate().getTime();
        long createDate = food.getCreateDate().getTime();
        long now = System.currentTimeMillis();
        long fullExpireDate = expireDate - createDate;
        long actualExpireDate = now - createDate;
        return (double) actualExpireDate / fullExpireDate * 100;
    }
}
