package game.controllers;

import game.display.Console;
import game.display.ConsoleParser;

import java.io.IOException;

class ConsoleMock extends Console {

    boolean verifyWriteCalled = false;
    boolean verifyReadCalled = false;

    ConsoleMock(ConsoleParser parser) {
        super(parser);
    }

    @Override
    public void read() throws IOException {
        verifyReadCalled = true;
    }

    @Override
    public void write(String text) throws IOException {
        verifyWriteCalled = true;
    }
}
