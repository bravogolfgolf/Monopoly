package game.controllers.writer;

import java.util.Map;

public interface WriterPresenter {

    Map<Integer,String> returnAndClearMenuMap();

    String getFormattedMessage();
}
