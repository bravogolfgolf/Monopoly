package game.view;

import game.controllers.View;

import java.io.IOException;
import java.util.Map;

public class ViewImpl implements View {

    private final Console console;
    private final Manager manager;
    private Map<Integer, String> menuMap;
    private Controller controller;

    public ViewImpl(Console console, Manager manager) {
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

    public void read() throws IOException {
        parse(console.read());
    }

    @Override
    public void write(String text) throws IOException {
        console.write(text);
    }

    protected void parse(String line) throws IOException {
        int selection;

        try {
            selection = Integer.parseInt(line);

            String result = menuMap.get(selection);
            if (selection == 0) manager.validNumber();
            else if (result == null) manager.invalidEntry();
            else manager.validTextEntry(controller, result);

        } catch (NumberFormatException e) {
            manager.invalidEntry();
        }
    }
}
