package game.controllers;

import game.view.Console;
import game.view.SetupGameView;

import java.io.IOException;
import java.util.Map;

class SetupGameViewMock extends SetupGameView {

    boolean verifyUserInterfacePromptCalled = false;
    boolean verifySetMapCalled = false;
    boolean verifyWriteCalled = false;

    SetupGameViewMock(Console console, Manager manager) {
        super(console, manager);
    }

    @Override
    public void setMap(Map<Integer, String> menuMap) {
        verifySetMapCalled = true;
        super.setMap(menuMap);
    }

    @Override
    public void read() throws IOException {
        parse("1");
    }

    @Override
    public void write(String text) throws IOException {
        verifyWriteCalled = true;
    }

    @Override
    public void userInterfacePrompt() throws IOException {
        verifyUserInterfacePromptCalled = true;
    }
}

