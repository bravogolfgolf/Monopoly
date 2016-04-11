package game.view;

import game.controllers.View;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Console extends View {

    private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    @Override
     public void output(String text) throws IOException {
        writer.write(text);
        writer.flush();
    }
}
