package christmas.domain.condition;

import christmas.domain.Bassi;

public interface BassiCondition {

    boolean isMoreThanMinPrice(int price);

    Bassi getBassiOnCondition(int price);
}
