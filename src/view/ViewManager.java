package game.view;

import java.io.IOException;

public interface ViewManager {

    void validTextEntry(String result) throws IOException;

    void invalidEntry() throws IOException;

    void validNumber() throws IOException;
}
