package game.controllers;

import game.entities.Dice;

import java.util.Map;

public interface ControllerPresenter {

    String getFormattedMessage();

    Map<Integer,String> returnAndClearMenuMap();

    void startTurnMessage();

    void rollMessage(Dice dice);
}
