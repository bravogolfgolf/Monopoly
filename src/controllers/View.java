package game.controllers;

import java.io.IOException;

public interface View {

    String read() throws IOException;

    void write(String text) throws IOException;
}
