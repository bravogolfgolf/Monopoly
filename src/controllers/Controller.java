package controllers;

import java.io.IOException;

public interface Controller {

    void handle(String text) throws IOException;
}
