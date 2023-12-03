package christmas.domain;

import javax.swing.plaf.BorderUIResource;
import java.time.DateTimeException;
import java.time.LocalDate;

public class EventDate {

    private static final int YEAR = 2023;
    private static final int MONTH = 12;

    private final LocalDate date;

    private EventDate(LocalDate date) {
        this.date = date;
    }

    public static EventDate from(int day){
        try {
            LocalDate.of(YEAR, MONTH, day);
        } catch (DateTimeException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_VALID_DATE, e);
        }
        return new EventDate(LocalDate.of(YEAR, MONTH, day));
    }

    public boolean isSameDate(int day){
        return this.date.getDayOfMonth() == day;
    }

    @Override
    public String toString() {
        return "EventDate{" +
                "date=" + date +
                '}';
    }
}
