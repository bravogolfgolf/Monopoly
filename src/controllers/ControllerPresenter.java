package game.controllers;

import java.io.IOException;
import java.util.Map;

public interface ControllerPresenter {

    void writeMessage() throws IOException;

    Map<Integer,String> returnAndClearMenuMap();

    void startTurnMessage();
}
