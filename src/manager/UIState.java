package game.manager;

import java.io.IOException;

interface UIState {

    void initialize(UIManager manager) throws IOException;

    void validNumber(UIManager manager) throws IOException;

    void validTextEntry(UIManager manager) throws IOException;

    void invalidEntry(UIManager manager) throws IOException;
}