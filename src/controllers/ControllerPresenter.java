package game.controllers;

import java.util.Map;

public interface ControllerPresenter {

    String getFormattedMessage();

    Map<Integer,String> returnAndClearMenuMap();

    void startTurnMessage();
}
