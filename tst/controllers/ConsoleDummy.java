package game.controllers;

import game.view.ViewConsole;

import java.io.IOException;

class ConsoleDummy implements ViewConsole {

    @Override
    public String read() throws IOException {
        return null;
    }

    @Override
    public void write(String text) throws IOException {

    }
}
