package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class StartTurn extends Fixture {

    public StartTurn() throws IOException {
        new StartTurn(StateImpl.NORMAL_TURN);
    }

    private StartTurn(StateImpl state) throws IOException {
        super(state);
    }
}
