package christmas.domain.discount;

import christmas.domain.EventDate;

public abstract class Discount {

    private final String title;
    private final int price;

    protected Discount(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
