package game.view;

import java.io.IOException;

public interface Console {

    String read() throws IOException;

    void write(String text) throws IOException;
}
