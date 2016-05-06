package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class ChooseMinimumNumberOfPlayers extends FitnesseFixture {

    public ChooseMinimumNumberOfPlayers() throws IOException {
        fitnesse.setup(StateImpl.CREATE_PLAYER_0);
    }
}
