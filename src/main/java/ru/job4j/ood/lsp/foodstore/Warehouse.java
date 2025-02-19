package ru.job4j.ood.lsp.foodstore;

public class Warehouse extends AbstractStore {
    @Override
    public boolean isDelivery(Food food) {
        double freshness = getFreshness(food);
        return freshness > 0 && freshness < 25;
    }
}
