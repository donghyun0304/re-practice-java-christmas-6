package christmas.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum Bassi {

    STAR("별", price -> isMoreThan(price, 5_000) && isLessThan(price, 10_000)),
    TREE("트리", price -> isMoreThan(price, 10_000) && isLessThan(price, 20_000)),
    SANTA("산타", price -> isMoreThan(price, 20_000));

    private String name;
    private Predicate<Integer> predicate;

    Bassi(String name, Predicate<Integer> predicate) {
        this.name = name;
        this.predicate = predicate;
    }

    private static boolean isMoreThan(int price, int standard){
        if(price >= standard){
            return true;
        }
        return false;
    }

    private static boolean isLessThan(int price, int standard){
        if(price < standard){
            return true;
        }
        return false;
    }

    public static Bassi findOnCondition(int price){
        return Arrays.stream(values())
                .filter(bassi -> bassi.predicate.test(price))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 배지를 찾을 수 없습니다."));
    }

    public String getName() {
        return name;
    }
}
