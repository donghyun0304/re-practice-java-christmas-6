package christmas.domain;

public class Present<T extends Food> {

    private final T present;

    public Present(T present) {
        this.present = present;
    }

    public T getPresent() {
        return present;
    }

    public String getName(){
        return present.getName();
    }

    public int getPrice(){
        return present.getPrice();
    }
}
