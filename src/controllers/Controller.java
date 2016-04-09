package controllers;

import interactors.Request;

import java.io.IOException;

public interface Controller {
    void sendRequest(Request request) throws IOException;
}
