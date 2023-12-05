package christmas.domain.condition;

import christmas.domain.Food;

public class PresentConditionImpl implements PresentCondition{

    private static final int MIN_PRICE = 120_000;

    @Override
    public boolean isMoreThanMinPrice(int price) {
        return false;
    }

    @Override
    public Food getPresent() {
        return Food.CHAMPAGNE;
    }
}
