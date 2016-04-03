package pkg.game;

import java.util.ArrayList;
import java.util.List;

class PlayerMockAlternateOrder extends Player {

    static final List<Player> order = new ArrayList<>();

    PlayerMockAlternateOrder() {
        super("PlayerMockAlternateOrder");
    }

    @Override
    public void takeATurn(Dice dice) {
        order.add(this);
    }
}