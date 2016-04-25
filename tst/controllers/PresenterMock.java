package game.controllers;

import java.util.Hashtable;
import java.util.Map;

class PresenterMock implements ControllerPresenter {

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
