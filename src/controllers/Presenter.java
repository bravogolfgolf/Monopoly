package game.controllers;

import game.interactors.Response;

public interface Presenter {
    void present(Response response);

    String getViewRequest();
}
