package game.controllers;

import game.parser.Parser;

import java.util.Map;

class ParserMock extends Parser {

    boolean verifySetMapCalled = false;

    @Override
    public void setMap(Map<Integer, String> menuMap) {
        verifySetMapCalled = true;
        super.setMap(menuMap);
    }
}
