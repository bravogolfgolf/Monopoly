package game.view;

import game.controllers.View;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Console extends View {

    private BufferedReader reader;
    private BufferedWriter writer;

    public Console(BufferedReader reader, BufferedWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public String input() throws IOException {
        return reader.readLine();
    }

    @Override
    public void output(String text) throws IOException {
        writer.write(text);
        writer.flush();
    }
}
