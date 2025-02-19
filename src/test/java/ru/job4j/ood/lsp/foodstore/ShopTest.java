package ru.job4j.ood.lsp.foodstore;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ShopTest {

    @Test
    public void whenFoodExpirationDateMeetsRequirementsThenReturnTrue() {
        Store shop = new Shop();
        Calendar today = Calendar.getInstance();
        Calendar breadCreate = (Calendar) today.clone();
        breadCreate.add(Calendar.DAY_OF_MONTH, -7);
        Calendar breadExpiry = (Calendar) today.clone();
        breadExpiry.add(Calendar.DAY_OF_MONTH, 5);
        Food bread = new Food("Хлеб", breadExpiry.getTime(), breadCreate.getTime(), 30.0);
        assertThat(shop.isDelivery(bread)).isTrue();
    }

    @Test
    public void whenAddFoodWithAnExpirationDateThenSetDiscount() {
        Store shop = new Shop();
        Calendar today = Calendar.getInstance();
        Calendar breadCreate = (Calendar) today.clone();
        breadCreate.add(Calendar.DAY_OF_MONTH, -7);
        Calendar breadExpiry = (Calendar) today.clone();
        breadExpiry.add(Calendar.DAY_OF_MONTH, 1);
        Food bread = new Food("Хлеб", breadExpiry.getTime(), breadCreate.getTime(), 30.0);
        shop.add(bread);
        assertThat(bread.getDiscount()).isEqualTo(24.0);
    }
}