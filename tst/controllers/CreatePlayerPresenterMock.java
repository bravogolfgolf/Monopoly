package game.controllers;

import java.util.Hashtable;
import java.util.Map;

class CreatePlayerPresenterMock implements Presenter {

    boolean verifyGetMenuMapCalled = false;
    int verifyGetFormattedMessageCalledCount = 0;

    @Override
    public String getFormattedMessage() {
        verifyGetFormattedMessageCalledCount++;
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
