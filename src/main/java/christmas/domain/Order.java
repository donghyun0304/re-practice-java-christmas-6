package christmas.domain;

import christmas.domain.condition.DiscountCondition;
import christmas.domain.condition.PresentCondition;
import christmas.domain.discount.*;

import java.util.Optional;

public class Order {

    private static final int ZERO = 0;
    private final OrderedFoods foods;
    private final Discounts discounts;
    private final DiscountCondition discountCondition;
    private final PresentCondition presentCondition;

    private Order(final OrderedFoods foods, final Discounts discounts,
                  final DiscountCondition discountCondition, final PresentCondition presentCondition) {
        this.foods = foods;
        this.discounts = discounts;
        this.discountCondition = discountCondition;
        this.presentCondition = presentCondition;
    }

    public static Order of(final OrderedFoods foods, final Discounts discounts,
                           final DiscountCondition discountCondition, final PresentCondition presentCondition){
        return new Order(foods, discounts, discountCondition, presentCondition);
    }

    public int calcTotalPriceBeforeDiscounts(){
        return foods.calcSumOfPricesOfFoods();
    }

    public int calcDiscountPrice(){
        return calcChristmasDiscount() +
                calcWeekdayDiscount() +
                calcWeekendDiscount() +
                calcSpecialDiscount();
    }

    public int calcChristmasDiscount(){
        if(!isMoreThanMinPrice()) {
            return ZERO;
        }
        return findDiscountAndCalcDiscountPrice(ChristmasDiscount.class);
    }

    public int calcWeekdayDiscount(){
        if(!isMoreThanMinPrice()) {
            return ZERO;
        }
        return findDiscountAndCalcDiscountPriceWithMenu(
                WeekdayDiscount.class, discountCondition.getWeekdayDiscountMenu());
    }

    public int calcWeekendDiscount(){
        if(!isMoreThanMinPrice()) {
            return ZERO;
        }
        return findDiscountAndCalcDiscountPriceWithMenu(
                WeekendDiscount.class, discountCondition.getWeekendDiscountMenu());
    }

    public int calcSpecialDiscount(){
        if(!isMoreThanMinPrice()) {
            return ZERO;
        }
        return findDiscountAndCalcDiscountPrice(SpecialDiscount.class);
    }

    private int findDiscountAndCalcDiscountPrice(Class<? extends Discount> discountClass){
        return findDiscount(discountClass)
                .map(Discount::getPrice)
                .orElse(ZERO);
    }

    private int findDiscountAndCalcDiscountPriceWithMenu(Class<? extends Discount> discountClass, Menu menu){
        return findDiscount(discountClass)
                .map(discount ->
                        discount.getPrice() * foods.calcAmountOfFoods(menu))
                .orElse(ZERO);
    }

    private Optional<Discount> findDiscount(Class<? extends Discount> discountClass){
        return discounts.findDiscount(discountClass);
    }

    private boolean isMoreThanMinPrice() {
        return discountCondition.isMoreThanMinPrice(calcTotalPriceBeforeDiscounts());
    }

//    private boolean hasOnlyDrinks(DiscountCondition discountCondition){
//        List<Food> foods = Converter.parseToKeyTypeList(this.foods.getFoods());
//        return discountCondition.hasOnlyDrinks(foods);
//    }


}
