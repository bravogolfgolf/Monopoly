package game.parser;

import java.io.IOException;

public interface ParserManager {

    void validTextEntry(String result) throws IOException;

    void invalidEntry() throws IOException;

    void zeroEntered() throws IOException;
}
