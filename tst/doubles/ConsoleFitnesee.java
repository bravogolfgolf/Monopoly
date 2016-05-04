package game.doubles;

import game.display.Console;
import game.parser.Parser;

import java.io.IOException;

public class ConsoleFitnesee extends Console {

    public Parser parser;
    public String expectedOutput;

    public ConsoleFitnesee(Parser parser) {
        super(parser);
        this.parser = parser;
    }

    @Override
    public void read() throws IOException {

    }

    @Override
    public void write(String text) throws IOException {
        expectedOutput = text;
    }
}
