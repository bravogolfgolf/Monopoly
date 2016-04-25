package game.display;

import game.manager.ManagerConsole;
import game.parser.ControllerConsole;

import java.io.*;

public class Console implements ControllerConsole, ManagerConsole {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private final ConsoleParser parser;

    public Console(ConsoleParser parser) {
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
