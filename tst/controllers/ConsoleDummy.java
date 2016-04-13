package game.controllers;

import java.io.IOException;

public class ConsoleDummy extends View {
    @Override
    public String input() throws IOException {
        return null;
    }

    @Override
    public void output(String text) throws IOException {

    }
}
