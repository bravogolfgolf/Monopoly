package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class ChooseVersion extends FitnesseFixture {

    public ChooseVersion() throws IOException {
        new ChooseVersion(StateImpl.VERSION);
    }

    private ChooseVersion(StateImpl state) throws IOException {
        super(state);
    }
}
