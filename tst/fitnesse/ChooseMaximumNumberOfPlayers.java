package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class ChooseMaximumNumberOfPlayers extends FitnesseFixture {

    public ChooseMaximumNumberOfPlayers() throws IOException {
        new ChooseMaximumNumberOfPlayers(StateImpl.CREATE_PLAYER_0);
    }

    private ChooseMaximumNumberOfPlayers(StateImpl state) throws IOException {
        super(state);
    }
}
