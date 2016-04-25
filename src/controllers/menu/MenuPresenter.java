package game.controllers.menu;

import java.util.Map;

public interface MenuPresenter {

    Map<Integer,String> returnAndClearMenuMap();

    String getFormattedMessage();
}
