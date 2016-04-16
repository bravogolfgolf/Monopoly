package game.view;

import game.controllers.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Console implements View {

    private final BufferedReader reader;
    private final BufferedWriter writer;

    public Console(BufferedReader reader, BufferedWriter writer) {
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
