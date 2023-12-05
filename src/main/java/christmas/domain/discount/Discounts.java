package christmas.domain.discount;

import java.util.List;
import java.util.Optional;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public Optional<Discount> findDiscount(Class<? extends Discount> discountClass){
        return discounts.stream()
                .filter(discountClass::isInstance)
                .findAny();
    }

    @Override
    public String toString() {
        return "Discounts{" +
                "discounts=" + discounts +
                '}';
    }
}
