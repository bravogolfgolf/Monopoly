package game.controllers;

import game.controllers.writer.WriterPresenter;
import game.controllers.writerreader.ReaderPresenter;

import java.util.Hashtable;
import java.util.Map;

class PresenterMock implements ReaderPresenter, WriterPresenter {

    boolean verifyGetMenuMapCalled = false;
    boolean verifyGetFormattedMessageCalled = false;
    boolean verifyStartTurnMessageCalled = false;

    @Override
    public String getFormattedMessage() {
        verifyGetFormattedMessageCalled = true;
        return null;
    }

    @Override
    public void startTurnMessage() {
        verifyStartTurnMessageCalled = true;
    }

    @Override
    public Map<Integer, String> returnAndClearMenuMap() {
        verifyGetMenuMapCalled = true;
        return new Hashtable<Integer, String>() {{
            put(1, "USA");
        }};
    }
}
