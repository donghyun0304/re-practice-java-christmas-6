package christmas.domain;

import java.util.Arrays;
import java.util.List;

public enum Menu {

    APPETIZER("애피타이저", Arrays.asList(Food.SWEET_POTATO_SOUP, Food.TAPAS, Food.CAESAR_SALAD)),
    MAIN("메인", Arrays.asList(Food.T_BONE_STEAK, Food.BARBECUE_LIP, Food.SEAFOOD_PASTA, Food.CHRISTMAS_PASTA)),
    DESSERT("디저트", Arrays.asList(Food.CHOCOLATE_CAKE, Food.ICE_CREAM)),
    DRINKS("음료", Arrays.asList(Food.ZERO_COLA, Food.RED_WINE, Food.CHAMPAGNE));

    private final String title;
    private final List<Food> foods;

    Menu(String title, List<Food> foods) {
        this.title = title;
        this.foods = foods;
    }

    public static boolean hasFoodInCategory(final Menu menu, final Food food){
        return menu.foods.contains(food);
    }
}
