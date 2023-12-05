package christmas.domain.condition;

import christmas.domain.Food;
import christmas.domain.Present;

public class PresentConditionImpl implements PresentCondition{

    private static final int MIN_PRICE = 120_000;

    @Override
    public boolean isMoreThanMinPrice(int price) {
        if(price >= MIN_PRICE){
            return true;
        }
        return false;
    }

    @Override
    public Present getPresent() {
        return new Present(Food.CHAMPAGNE);
    }

}
