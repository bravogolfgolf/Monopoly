package game.controllers;

import game.view.View;
import game.view.ViewConsole;

import java.io.IOException;
import java.util.Map;

class ViewMock extends View {

    boolean verifySetMapCalled = false;
    boolean verifyWriteCalled = false;

    ViewMock(ViewConsole console) {
        super(console);
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
