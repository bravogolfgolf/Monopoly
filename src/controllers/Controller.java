package game.controllers;

import game.parser.ControllerConsole;

import java.io.IOException;

public abstract class Controller {

    protected final ControllerConsole console;

    protected Controller(ControllerConsole console) {
        this.console = console;
    }

    public abstract void execute() throws IOException;

    protected void read() throws IOException {
        console.read();
    }

    public abstract void handle(String text) throws IOException;
}
