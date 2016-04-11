package game.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class View {
    public final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public abstract void output(String text) throws IOException;
}
