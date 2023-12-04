package christmas.domain.discount;

import christmas.domain.DiscountCalendar;
import christmas.domain.EventDate;

public class SpecialDiscount extends Discount{

    private static final String SPECIAL_TITLE = "특별 할인";
    private static final int PRICE = 1_000;

    private SpecialDiscount() {
        super(SPECIAL_TITLE, PRICE);
    }

    public static Discount from(EventDate eventDate){
        if(!isSpecial(eventDate)){
            throw new IllegalArgumentException("[ERROR] 특별 이벤트 날짜에 속하지 않습니다.");
        }
        return new SpecialDiscount();
    }

    private static boolean isSpecial(EventDate eventDate){
        return DiscountCalendar.isEventDay(DiscountCalendar.SPECIAL , eventDate);
    }
}
