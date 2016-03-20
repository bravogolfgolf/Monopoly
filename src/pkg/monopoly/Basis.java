package pkg.monopoly;

class Basis {
    private final boolean aDefault;
    private final int value;

    Basis(int value) {
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
