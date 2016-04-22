package game.view;

import java.io.IOException;

public interface Manager {

    void initialize();

    void validTextEntry(Controller controller, String result) throws IOException;

    void invalidEntry();

    void validNumber();
}
