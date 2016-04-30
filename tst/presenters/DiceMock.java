package game.presenters;

import game.entities.Dice;

public class DiceMock extends Dice {

    DiceMock(int rolled, boolean doubles) {
        super(rolled, doubles);
    }

    @Override
    public int rolled() {
        return super.rolled();
    }

    @Override
    public boolean isDoubles() {
        return super.isDoubles();
    }
}