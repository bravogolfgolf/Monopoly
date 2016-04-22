package game.manager;

import java.io.IOException;

public interface Controller {

    void execute() throws IOException;

    void handle(String text) throws IOException;
}
