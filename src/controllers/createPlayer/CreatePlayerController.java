package controllers.createPlayer;

import controllers.Controller;
import usecases.Interactor;
import usecases.Request;

import java.io.BufferedReader;
import java.io.IOException;

public class CreatePlayerController implements Controller {
    private Interactor interactor;
    private BufferedReader view;

    public void sendRequest(Request request) throws IOException {
        interactor.handle(request);
    }

    public void setView(BufferedReader view) {
        this.view = view;
    }

    public void setInteractor(Interactor interactor) {
        this.interactor = interactor;
    }
}
