package game.view;

import game.controllers.ControllerView;
import game.manager.ManagerView;

import java.io.IOException;
import java.util.Map;

public class View implements ControllerView, ManagerView {

    private final ViewConsole console;
    private ViewManager manager;
    private Map<Integer, String> menuMap;

    public View(ViewConsole console) {
        this.console = console;
    }

    @Override
    public void setManager(ViewManager manager) {
        this.manager = manager;
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

    protected void parse(String line) throws IOException {
        int selection;

        try {
            selection = Integer.parseInt(line);

            String result = menuMap.get(selection);
            if (selection == 0) manager.validNumber();
            else if (result == null) manager.invalidEntry();
            else manager.validTextEntry(result);

        } catch (NumberFormatException e) {
            manager.invalidEntry();
        }
    }
}
