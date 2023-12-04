package christmas.domain;

import java.util.Arrays;
import java.util.EnumMap;

public class Foods {

    private final EnumMap<Food, Integer> foods;

    public Foods(final EnumMap<Food, Integer> foods) {
        this.foods = new EnumMap<>(Food.class);
    }

    public int calcSumOfPricesOfFoods(){
        return foods.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }


}
