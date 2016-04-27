package game.controllers;

import game.parser.ControllerConsole;

import java.io.IOException;

class ConsoleMock implements ControllerConsole {

    boolean verifyWriteCalled = false;
    boolean verifyReadCalled = false;

    @Override
    public void read() throws IOException {
        verifyReadCalled = true;
    }

    @Override
    public void write(String text) throws IOException {
        verifyWriteCalled = true;
    }
}
