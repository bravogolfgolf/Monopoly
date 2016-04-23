package game.controllers;

import java.util.Hashtable;
import java.util.Map;

class CreatePlayerPresenterMock implements ControllerPresenter {

    boolean verifyGetMenuMapCalled = false;

    @Override
    public String getFormattedMessage() {
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
