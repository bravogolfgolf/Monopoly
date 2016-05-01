package game.controllers;

import java.io.IOException;

public interface ControllerPresenter {

    void writeMessage() throws IOException;

    void startTurnMessage();
}
