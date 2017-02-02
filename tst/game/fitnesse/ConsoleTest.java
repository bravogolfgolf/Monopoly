package game.fitnesse;

import game.display.Console;
import game.parser.Parser;

import java.io.IOException;

public class ConsoleTest extends Console {

    StringBuffer bufferedOutput = new StringBuffer();

    public ConsoleTest(Parser parser) {
        super(parser);
    }

    @Override
    public void read() throws IOException {

    }

    @Override
    public void write(String text) throws IOException {
        bufferedOutput.append(text);
    }
}
