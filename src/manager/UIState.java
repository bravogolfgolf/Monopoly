package game.manager;

import java.io.IOException;

interface UIState {

    void initialize(UIManager manager) throws IOException;

    void validNumber(UIManager manager);

    void validTextEntry(UIManager manager);

    void invalidEntry(UIManager manager);
}