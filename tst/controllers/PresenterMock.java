package game.controllers;

import game.controllers.basic.BasicPresenter;
import game.controllers.menu.MenuPresenter;

import java.util.Hashtable;
import java.util.Map;

class PresenterMock implements BasicPresenter, MenuPresenter {

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
