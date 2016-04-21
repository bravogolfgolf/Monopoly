package game.view;

import game.controllers.View;

import java.io.IOException;
import java.util.Map;

public class SetupGameView implements View {

    private final Console console;
    private final Manager manager;
    private Map<Integer, String> menuMap;
    private Controller controller;

    public SetupGameView(Console console, Manager manager) {
        this.console = console;
        this.manager = manager;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void setMap(Map<Integer, String> menuMap) {
        this.menuMap = menuMap;
    }

    @Override
    public void read() throws IOException {
        parse(console.read());
    }

    @Override
    public void write(String text) throws IOException {
        console.write(text);
    }

    @Override
    public void userInterfacePrompt() throws IOException {
        manager.promptMessage();
    }

    protected void parse(String line) throws IOException {
        int selection;

        try {
            selection = Integer.parseInt(line);
            String result = menuMap.get(selection);
            if (result == null)
                manager.invalidEntry();
            else {
                controller.handle(result);
                manager.validUseCaseEntry();
            }

        } catch (NumberFormatException e) {
            manager.invalidEntry();
        }
    }
}
