package game.controllers;

import java.io.IOException;

public abstract class View {
    public abstract String read() throws IOException;

    public abstract void write(String text) throws IOException;
}
