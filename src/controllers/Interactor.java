package game.controllers;

import game.interactors.Request;

public interface Interactor {
    void handle(Request request);
}
