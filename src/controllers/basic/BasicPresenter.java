package game.controllers.basic;

import java.util.Map;

public interface BasicPresenter {

    String getFormattedMessage();

    Map<Integer, String> returnAndClearMenuMap();
}
