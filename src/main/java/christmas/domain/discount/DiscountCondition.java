package christmas.domain.discount;

import christmas.domain.Food;

import java.util.List;

public interface DiscountCondition {

    boolean isMoreThanMinPrice(int price);

    boolean hasOnlyDrinks(List<Food> foods);
}
