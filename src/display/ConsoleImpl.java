package game.display;

import game.view.Console;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ConsoleImpl implements Console {

    private final BufferedReader reader;
    private final BufferedWriter writer;

    public ConsoleImpl(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public String read() throws IOException {
        return reader.readLine();
    }

    @Override
    public void write(String text) throws IOException {
        writer.write(text);
        writer.flush();
    }
}
