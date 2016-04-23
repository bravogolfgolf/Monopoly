package game.view;

import java.io.IOException;

public interface ViewConsole {

    String read() throws IOException;

    void write(String text) throws IOException;
}
