package game.display;

import game.manager.ManagerConsole;
import game.parser.ControllerConsole;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Console implements ControllerConsole, ManagerConsole {

    private final BufferedReader reader;
    private final BufferedWriter writer;
    private final ConsoleParser parser;

    public Console(BufferedReader reader, BufferedWriter writer, ConsoleParser parser) {
        this.reader = reader;
        this.writer = writer;
        this.parser = parser;
    }

    @Override
    public void read() throws IOException {
        parser.parse(reader.readLine());
    }

    @Override
    public void write(String text) throws IOException {
        writer.write(text);
        writer.flush();
    }
}
