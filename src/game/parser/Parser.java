package game.parser;

import game.controllers.ControllerParser;
import game.display.ConsoleParser;
import game.presenters.PresenterParser;

import java.io.IOException;
import java.util.Map;

public class Parser implements ConsoleParser, ControllerParser, PresenterParser {

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
            if (result == null)
                if (selection == 0) manager.zeroEntered();
                else if (selection == 1) manager.oneEntered();
                else if (selection == 2) manager.twoEntered();
                else manager.invalidEntry();
            else manager.validTextEntry(result);

        } catch (NumberFormatException e) {
            manager.invalidEntry();
        }
    }
}
