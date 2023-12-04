package christmas.domain.discount;

import christmas.domain.DiscountCalendar;
import christmas.domain.EventDate;

public class ChristmasDiscount extends Discount{

    private static final String CHRISTMAS_TITLE = "크리스마스 디데이 할인";
    private static final int START_PRICE = 1000;
    private static final int INCREASING_PRICE_PER_DAY = 100;
    private ChristmasDiscount(int price) {
        super(CHRISTMAS_TITLE, price);
    }

    public static Discount from(EventDate eventDate){
        if(!isChristmasDate(eventDate)){
            throw new IllegalArgumentException("[ERROR] 크리스마스 이벤트 날짜에 속하지 않습니다.");
        }
        return new ChristmasDiscount(calcPrice(eventDate));
    }

    private static boolean isChristmasDate(EventDate eventDate){
        return DiscountCalendar.isEventDay(DiscountCalendar.CHRISTMAS , eventDate);
    }

    private static int calcPrice(EventDate eventDate){
        int days = DiscountCalendar.calcDaysFromStartChristMas(eventDate);
        return START_PRICE + (days * INCREASING_PRICE_PER_DAY);
    }










}
