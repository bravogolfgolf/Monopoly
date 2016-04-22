package game.view;

import java.io.IOException;

public interface Manager {

    void validTextEntry(String result) throws IOException;

    void invalidEntry() throws IOException;

    void validNumber() throws IOException;
}
