package game.doubles;

import game.parser.Parser;

import java.util.Map;

public class ParserMock extends Parser {

    public boolean verifySetMapCalled = false;
    public boolean verifyClearMapCalled = false;

    @Override
    public void clearMap() {
        verifyClearMapCalled = true;
    }

    @Override
    public void setMap(Map<Integer, String> menuMap) {
        verifySetMapCalled = true;
    }
}
