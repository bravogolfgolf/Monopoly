package game.doubles;

import game.display.Console;
import game.display.ConsoleParser;

import java.io.IOException;

public class ConsoleMock extends Console {

    public boolean verifyReadCalled = false;
    public String verifyWriteMessage;

    public ConsoleMock(ConsoleParser parser) {
        super(parser);
    }

    @Override
    public void read() throws IOException {
        verifyReadCalled = true;
    }

    @Override
    public void write(String text) throws IOException {
        verifyWriteMessage = text;
    }
}
