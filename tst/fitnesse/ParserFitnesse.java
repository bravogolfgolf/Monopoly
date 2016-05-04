package game.fitnesse;

import game.controllers.Options;
import game.parser.Parser;

import java.io.IOException;
import java.util.Map;

public class ParserFitnesse extends Parser {

    Options controller;
    private Map<Integer, String> menuMap;

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
                if (selection == 0) controller.execute();
                else if (selection == 1) controller.execute();
                else if (selection == 2) controller.execute();
                else controller.execute();
            else controller.handle(result);

        } catch (NumberFormatException e) {
            controller.execute();
        }
    }
}
