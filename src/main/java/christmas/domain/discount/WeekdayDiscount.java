package christmas.domain.discount;

import christmas.domain.DiscountCalendar;
import christmas.domain.EventDate;

public class WeekdayDiscount extends Discount{

    private static final String CHRISTMAS_TITLE = "평일 할인";
    private static final int PRICE = 2_023;

    private WeekdayDiscount() {
        super(CHRISTMAS_TITLE, PRICE);
    }

    public static Discount from(EventDate eventDate){
        if(!isWeekday(eventDate)){
            throw new IllegalArgumentException("[ERROR] 평일 이벤트 날짜에 속하지 않습니다.");
        }
        return new WeekdayDiscount();
    }

    private static boolean isWeekday(EventDate eventDate){
        return DiscountCalendar.isEventDay(DiscountCalendar.WEEKDAYS , eventDate);
    }
}
