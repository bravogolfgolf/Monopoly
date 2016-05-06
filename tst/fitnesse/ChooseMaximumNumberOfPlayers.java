package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class ChooseMaximumNumberOfPlayers extends FitnesseFixture {

    public ChooseMaximumNumberOfPlayers() throws IOException {
        fitnesse.setup(StateImpl.CREATE_PLAYER_2);
    }
}
