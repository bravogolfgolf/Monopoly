package game.parser;

import java.io.IOException;

public interface ParserManager {

    void invalidEntry() throws IOException;

    void validTextEntry(String result) throws IOException;

    void zeroEntered() throws IOException;

    void oneEntered() throws IOException;

    void twoEntered();
}
