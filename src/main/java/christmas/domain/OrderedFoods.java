package christmas.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class OrderedFoods {

    private final Map<Food, Integer> foods;

    public OrderedFoods(final Map<Food, Integer> foods) {
        this.foods = new EnumMap<>(foods);
    }

    public int calcSumOfPricesOfFoods(){
        return foods.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int calcAmountOfFoods(Menu menu){
        return foods.entrySet().stream()
                .filter(entry -> Menu.hasFoodInCategory(menu, entry.getKey()))
                .mapToInt(entry -> entry.getValue())
                .sum();
    }

    public Map<Food, Integer> getFoods() {
        return Collections.unmodifiableMap(foods);
    }
}
