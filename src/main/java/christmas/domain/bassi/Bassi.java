package christmas.domain.bassi;

public abstract class Bassi {

    private final String name;

    public Bassi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
