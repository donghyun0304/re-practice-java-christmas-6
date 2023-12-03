package christmas.dto;

import christmas.domain.Food;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodsDto {

    private Map<Food, Integer> foods;

    private FoodsDto(final Map<Food, Integer> foods) {
        this.foods = foods;
    }

    public static FoodsDto from(final Map<String, Integer> foods){
        return new FoodsDto(parse(foods));
    }
    public Map<Food, Integer> getFoods() {
        return Collections.unmodifiableMap(foods);
    }

    private static Map<Food, Integer> parse(final Map<String, Integer> foods){
        return foods.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> Food.find(entry.getKey()),
                        entry -> entry.getValue()
                ));
    }

    @Override
    public String toString() {
        return "FoodsDto{" +
                "foods=" + foods +
                '}';
    }
}
