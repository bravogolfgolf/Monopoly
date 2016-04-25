package game.parser;

import game.controllers.menu.MenuParser;
import game.display.ConsoleParser;

import java.io.IOException;
import java.util.Map;

public class Parser implements ConsoleParser, MenuParser {

    private ParserManager manager;
    private Map<Integer, String> menuMap;

    public void setManager(ParserManager manager) {
        this.manager = manager;
    }

    @Override
    public void setMap(Map<Integer, String> menuMap) {
        this.menuMap = menuMap;
    }

    @Override
    public void parse(String line) throws IOException {
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
