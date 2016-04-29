package game.controllers;

import java.io.IOException;

public interface Handler {

    void handle(String text) throws IOException;
}
