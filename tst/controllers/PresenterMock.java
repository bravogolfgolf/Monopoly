package game.controllers;

import java.util.Hashtable;
import java.util.Map;

class PresenterMock implements Presenter {

    boolean verifyGetMenuMapCalled = false;
    boolean verifyGetFormattedMessageCalled = false;

    @Override
    public String getFormattedMessage() {
        verifyGetFormattedMessageCalled = true;
        return null;
    }

    @Override
    public Map<Integer, String> getMenuMap() {
        verifyGetMenuMapCalled = true;
        return new Hashtable<Integer, String>() {{
            put(1, "Cat");
        }};
    }
}
