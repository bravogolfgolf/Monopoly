package game.controllers;

import java.util.Map;

public interface Presenter {

    String getFormattedMessage();

    Map<Integer, String> getMenuMap();
}
