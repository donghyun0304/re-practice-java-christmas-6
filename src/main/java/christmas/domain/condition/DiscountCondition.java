package christmas.domain.discount;

import christmas.domain.Food;
import christmas.domain.Menu;

import java.util.List;

public interface DiscountCondition {

    boolean isMoreThanMinPrice(int price);

    Menu getWeekdayDiscountMenu();
    Menu getWeekendDiscountMenu();



//    boolean hasOnlyDrinks(List<Food> foods);
}
