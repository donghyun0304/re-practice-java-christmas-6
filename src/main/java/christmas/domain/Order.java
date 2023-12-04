package christmas.domain;

import christmas.domain.discount.Discounts;

import java.util.EnumMap;

public class Order {

    private final Foods foods;
    private final Discounts discounts;

    private Order(final Foods foods, final Discounts discounts) {
        this.foods = foods;
        this.discounts = discounts;
    }

    public static Order of(final Foods foods, final Discounts discounts){
        return new Order(foods, discounts);
    }

    public int calcTotalAmountBeforeDiscounts(){
        return foods.calcSumOfPricesOfFoods();
    }


}
