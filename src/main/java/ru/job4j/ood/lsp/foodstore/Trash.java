package ru.job4j.ood.lsp.foodstore;

public class Trash extends AbstractStore {
    @Override
    public boolean isDelivery(Food food) {
        double freshness = getFreshness(food);
        return freshness >= 100;
    }
}
