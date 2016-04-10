package controllers;

import interactors.Request;

public interface Interactor {
    void handle(Request request);
}
