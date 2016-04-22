package game.factories;

import game.controllers.View;

import java.io.IOException;
import java.util.Map;

class ViewDummy implements View {
    @Override
    public void setMap(Map<Integer, String> menuMap) {

    }

    @Override
    public void read() throws IOException {

    }

    @Override
    public void write(String text) throws IOException {

    }
}
