package christmas.service;

import christmas.domain.DiscountCalendar;
import christmas.domain.EventDate;
import christmas.domain.discount.*;

import java.util.ArrayList;
import java.util.List;

public class ChristmasEventService {

    public Discounts getApplicableDiscounts(EventDate eventDate){
        List<Discount> discounts = new ArrayList<>();

        if(isEventDay(DiscountCalendar.CHRISTMAS, eventDate)){
            discounts.add(ChristmasDiscount.from(eventDate));
        }
        if(isEventDay(DiscountCalendar.WEEKDAYS, eventDate)){
            discounts.add(WeekdayDiscount.from(eventDate));
        }
        if(isEventDay(DiscountCalendar.WEEKENDS, eventDate)){
            discounts.add(WeekendDiscount.from(eventDate));
        }
        if(isEventDay(DiscountCalendar.SPECIAL, eventDate)){
            discounts.add(SpecialDiscount.from(eventDate));
        }
        return new Discounts(discounts);
    }

    private boolean isEventDay(DiscountCalendar discountCalendar, EventDate eventDate){
        return DiscountCalendar.isEventDay(discountCalendar, eventDate);
    }
}

