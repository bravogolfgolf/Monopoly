package game.controllers;

import game.parser.Parser;

import java.util.Map;

class ParserMock extends Parser {

    boolean verifySetMapCalled = false;
    boolean verifyClearMapCalled = false;

    @Override
    public void clearMap() {
        verifyClearMapCalled = true;
    }

    @Override
    public void setMap(Map<Integer, String> menuMap) {
        verifySetMapCalled = true;
    }
}
