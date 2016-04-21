package game.controllers;

import game.view.Controller;

import java.io.IOException;
import java.util.Map;

public interface View {

    void setController(Controller controller);

    void setMap(Map<Integer, String> menuMap);

    void read() throws IOException;

    void write(String text) throws IOException;

    void userInterfacePrompt() throws IOException;
}
