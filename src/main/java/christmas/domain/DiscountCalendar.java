package christmas.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.function.Predicate;

public enum DiscountCalendar {

    CHRISTMAS( eventDate ->
            eventDate.isBetween(LocalDate.of(2023,12,1), LocalDate.of(2023,12,25))),
    WEEKDAYS(eventDate -> {
        List<DayOfWeek> days =
                Arrays.asList(
                        DayOfWeek.SUNDAY,
                        DayOfWeek.MONDAY,
                        DayOfWeek.TUESDAY,
                        DayOfWeek.WEDNESDAY,
                        DayOfWeek.THURSDAY);
        return containsDayOfWeek(eventDate, days);
    }),
    WEEKENDS(eventDate -> {
        List<DayOfWeek> days =
                Arrays.asList(
                        DayOfWeek.FRIDAY,
                        DayOfWeek.SATURDAY);
        return containsDayOfWeek(eventDate, days);
    }),
    SPECIAL(eventDate -> {
        List<Integer> days = Arrays.asList(3, 10, 17, 24, 25, 31);
        return days.stream()
                .anyMatch(day -> eventDate.isSameDay(day));
    });

    private Predicate<EventDate> predicate;

    DiscountCalendar(Predicate<EventDate> predicate) {
        this.predicate = predicate;
    }

    private static boolean containsDayOfWeek(EventDate eventDate, List<DayOfWeek> days){
        return days.stream()
                .anyMatch(day -> eventDate.isSameDayOfWeek(day));
    }

    public static boolean isEventDay(DiscountCalendar discountCalendar, EventDate eventDate){
        return discountCalendar.predicate.test(eventDate);
    }

//    public static boolean hasChristMas(EventDate eventDate){
//        return CHRISTMAS.predicate.test(eventDate);
//    }
//
//    public static boolean hasWeekdays(EventDate eventDate){
//        return WEEKDAYS.predicate.test(eventDate);
//    }
//
//    public static boolean hasWeekends(EventDate eventDate){
//        return WEEKENDS.predicate.test(eventDate);
//    }
//
//    public static boolean hasSpecial(EventDate eventDate){
//        return SPECIAL.predicate.test(eventDate);
//    }










}
