package pkg.game;

public class Basis {
    private final boolean aDefault;
    private final int value;

    public Basis(int value) {
        this.value = value;
        this.aDefault = false;
    }

    Basis() {
        this.value = 1;
        this.aDefault = true;
    }

    public int value() {
        return value;
    }

    boolean isDefault() {
        return aDefault;
    }
}
