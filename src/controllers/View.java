package game.controllers;

import java.io.IOException;

public abstract class View {
    public abstract String input() throws IOException;

    public abstract void output(String text) throws IOException;
}
