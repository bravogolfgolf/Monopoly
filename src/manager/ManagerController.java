package game.manager;

import java.io.IOException;

public interface ManagerController {

    void execute() throws IOException;

    void handle(String text) throws IOException;
}
