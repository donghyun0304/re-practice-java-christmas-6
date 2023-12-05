package christmas.domain.condition;

import christmas.domain.Bassi;

public class BassiConditionImpl implements BassiCondition{

    private static final int MIN_PRICE = 5_000;

    @Override
    public boolean isMoreThanMinPrice(int price) {
        if(price >= MIN_PRICE){
            return true;
        }
        return false;
    }

    @Override
    public Bassi getBassiOnCondition(int price) {
        return Bassi.findOnCondition(price);
    }


}
