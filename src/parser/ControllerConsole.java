package game.parser;

import java.io.IOException;

public interface ControllerConsole {

    void read() throws IOException;

    void write(String text) throws IOException;
}
