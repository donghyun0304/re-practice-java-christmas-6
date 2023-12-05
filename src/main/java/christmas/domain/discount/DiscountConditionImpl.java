package christmas.domain.discount;

import christmas.domain.Food;
import christmas.domain.Menu;

import java.util.List;

public class DiscountConditionImpl implements DiscountCondition{

    private static final int MIN_PRICE = 10_000;
    @Override
    public boolean isMoreThanMinPrice(int price) {
        if(price >= MIN_PRICE){
            return true;
        }
        return false;
    }

    @Override
    public Menu getWeekdayDiscountMenu() {
        return Menu.DESSERT;
    }


//    @Override
//    public boolean hasOnlyDrinks(List<Food> foods) {
//        return foods.stream()
//                .allMatch(food -> Menu.hasFoodInCategory(Menu.DRINKS, food));
//    }
}
