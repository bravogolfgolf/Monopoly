package game.manager;

import java.io.IOException;

interface State {

    void initialize(StateManager manager) throws IOException;

    void validTextEntry(StateManager manager) throws IOException;

    void zeroEntered(StateManager manager) throws IOException;

    void oneEntered(StateManager manager) throws IOException;

    void twoEntered(StateManager manager);
}