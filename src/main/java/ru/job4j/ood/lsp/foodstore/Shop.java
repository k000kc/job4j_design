package ru.job4j.ood.lsp.foodstore;

public class Shop extends AbstractStore {
    @Override
    public boolean isDelivery(Food food) {
        double freshness = getFreshness(food);
        return freshness >= 25 && freshness < 100;
    }

    @Override
    public boolean add(Food food) {
        if (getFreshness(food) >= 75) {
            food.setDiscount(food.getPrice() * 0.8);
        }
        return super.add(food);
    }
}
