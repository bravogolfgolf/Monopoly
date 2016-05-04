package game.fitnesse;

import game.display.Console;
import game.parser.Parser;

import java.io.IOException;

public class ConsoleFitnesee extends Console {

    String expectedOutput;

    public ConsoleFitnesee(Parser parser) {
        super(parser);
    }

    @Override
    public void read() throws IOException {

    }

    @Override
    public void write(String text) throws IOException {
        expectedOutput = text;
    }
}
