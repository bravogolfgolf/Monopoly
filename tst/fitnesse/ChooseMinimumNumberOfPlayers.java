package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class ChooseMinimumNumberOfPlayers extends FitnesseFixture {

    public ChooseMinimumNumberOfPlayers() throws IOException {
        new ChooseMinimumNumberOfPlayers(StateImpl.CREATE_PLAYER_0);
    }

    private ChooseMinimumNumberOfPlayers(StateImpl state) throws IOException {
        super(state);
    }
}
