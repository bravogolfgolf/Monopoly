package game.controllers;

import game.view.Console;

import java.io.IOException;

class ConsoleDummy implements Console{

    @Override
    public String read() throws IOException {
        return null;
    }

    @Override
    public void write(String text) throws IOException {

    }
}
