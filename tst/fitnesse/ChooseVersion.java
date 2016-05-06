package game.fitnesse;

import game.manager.StateImpl;

import java.io.IOException;

public class ChooseVersion extends FitnesseFixture {

    public ChooseVersion() throws IOException {
        fitnesse.setup(StateImpl.VERSION);
    }
}
