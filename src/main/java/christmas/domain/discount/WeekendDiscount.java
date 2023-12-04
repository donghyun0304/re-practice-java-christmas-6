package christmas.domain.discount;

import christmas.domain.DiscountCalendar;
import christmas.domain.EventDate;

public class WeekendDiscount extends Discount{

    private static final String WEEKEND_TITLE = "주말 할인";
    private static final int PRICE = 2_023;

    private WeekendDiscount() {
        super(WEEKEND_TITLE, PRICE);
    }

    public static Discount from(EventDate eventDate){
        if(!isWeekend(eventDate)){
            throw new IllegalArgumentException("[ERROR] 주말 이벤트 날짜에 속하지 않습니다.");
        }
        return new WeekendDiscount();
    }

    private static boolean isWeekend(EventDate eventDate){
        return DiscountCalendar.isEventDay(DiscountCalendar.WEEKENDS , eventDate);
    }
}
