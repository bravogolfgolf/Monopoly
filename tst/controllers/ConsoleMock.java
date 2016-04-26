package game.controllers;

import game.parser.ControllerConsole;

import java.io.IOException;

class ConsoleMock implements ControllerConsole {

    boolean verifyWriteCalled = false;

    @Override
    public void read() throws IOException {

    }

    @Override
    public void write(String text) throws IOException {
        verifyWriteCalled = true;
    }
}
