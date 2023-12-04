package christmas.domain.discount;

import java.util.List;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "discounts=" + discounts +
                '}';
    }
}
