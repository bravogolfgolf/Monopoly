package pkg.game;

public class SourceOfMoveMultiplier {
    private final boolean aDefault;
    private final int value;

    public SourceOfMoveMultiplier(int value) {
        this.value = value;
        this.aDefault = false;
    }

    public SourceOfMoveMultiplier() {
        this.value = 1;
        this.aDefault = true;
    }

    public int value() {
        return value;
    }

    public boolean isDefault() {
        return aDefault;
    }
}
