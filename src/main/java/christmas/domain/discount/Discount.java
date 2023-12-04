package christmas.domain;

public abstract class Discount {

    private final int title;
    private final int price;

    public Discount(int title, int price) {
        this.title = title;
        this.price = price;
    }

}
