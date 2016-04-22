package game.controllers;

import game.view.Console;
import game.view.Manager;
import game.view.ViewImpl;

import java.io.IOException;
import java.util.Map;

class ViewImplMock extends ViewImpl {

    boolean verifySetMapCalled = false;
    boolean verifyWriteCalled = false;

    ViewImplMock(Console console, Manager manager) {
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
}
