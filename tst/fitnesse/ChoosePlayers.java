package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class ChoosePlayers extends Fixture {

    public ChoosePlayers() throws IOException {
        new ChoosePlayers(StateImpl.CREATE_PLAYER_0);
    }

    private ChoosePlayers(StateImpl state) throws IOException {
        super(state);
    }
}
