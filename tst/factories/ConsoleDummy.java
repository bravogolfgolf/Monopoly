package game.factories;

import game.controllers.ControllerView;

import java.io.IOException;
import java.util.Map;

class ConsoleDummy implements ControllerView {
    @Override
    public void setMap(Map<Integer, String> menuMap) {

    }

    @Override
    public void write(String text) throws IOException {

    }
}
