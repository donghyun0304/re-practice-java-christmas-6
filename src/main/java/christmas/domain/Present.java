package christmas.domain;

public class Present<T> {

    private final T present;

    public Present(T present) {
        this.present = present;
    }

    public T getPresent() {
        return present;
    }
}
