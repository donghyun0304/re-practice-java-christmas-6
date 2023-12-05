package christmas.domain.condition;

import christmas.domain.Food;

public interface PresentCondition {

    boolean isMoreThanMinPrice(int price);

    Food getPresent();

}
