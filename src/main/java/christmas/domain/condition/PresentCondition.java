package christmas.domain.condition;

import christmas.domain.Food;
import christmas.domain.Present;

public interface PresentCondition {

    boolean isMoreThanMinPrice(int price);

    Present getPresent();

}
