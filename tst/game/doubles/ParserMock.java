package game.doubles;

import game.parser.Parser;

import java.util.Map;

public class ParserMock extends Parser {

    public Map<Integer,String> verifySetMapValue;

    @Override
    public void setMap(Map<Integer, String> menuMap) {
        verifySetMapValue = menuMap;
    }
}
