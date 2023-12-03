package christmas.dto;

import christmas.domain.Food;

import java.util.Map;
import java.util.stream.Collectors;

public class FoodsDto {

    private Map<String, Integer> foods;

    public FoodsDto(Map<String, Integer> foods) {
        this.foods = foods;
    }

    public Map<Food, Integer> getFoods() {
        return parse(foods);
    }

    private Map<Food, Integer> parse(Map<String, Integer> foods){
        return foods.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> Food.find(entry.getKey()),
                        entry -> entry.getValue()
                ));
    }
}
