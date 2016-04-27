package game.controllers;

import game.controllers.writer.WriterPresenter;

import java.util.Hashtable;
import java.util.Map;

class PresenterMock implements ReaderPresenter, WriterPresenter {

    boolean verifyGetMenuMapCalled = false;
    boolean verifyGetFormattedMessage = false;

    @Override
    public String getFormattedMessage() {
        verifyGetFormattedMessage = true;
        return null;
    }

    @Override
    public Map<Integer, String> returnAndClearMenuMap() {
        verifyGetMenuMapCalled = true;
        return new Hashtable<Integer, String>() {{
            put(1, "USA");
        }};
    }
}
