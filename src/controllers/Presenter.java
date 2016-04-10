package controllers;

import interactors.Response;

public interface Presenter {
    void present(Response response);

    String getViewRequest();
}
