package game.controllers;

import java.io.IOException;
import java.util.Map;

public interface View {

    void setMap(Map<Integer, String> menuMap);

    void read() throws IOException;

    void write(String text) throws IOException;
}
