package game.controllers;

import game.view.Console;
import game.view.CreatePlayerView;

import java.io.IOException;
import java.util.Map;

class CreatePlayerViewMock extends CreatePlayerView {

    boolean verifyUserInterfacePromptCalled = false;
    boolean verifySetMapCalled = false;
    boolean verifyWriteCalled = false;

    CreatePlayerViewMock(Console console, Manager manager) {
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
        super.write(text);
    }

    @Override
    public void userInterfacePrompt() throws IOException {
        verifyUserInterfacePromptCalled = true;
    }
}
