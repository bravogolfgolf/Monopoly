package game.controllers;

import java.io.IOException;

public class ConsoleDummy implements View {
    @Override
    public String read() throws IOException {
        return null;
    }

    @Override
    public void write(String text) throws IOException {

    }
}
