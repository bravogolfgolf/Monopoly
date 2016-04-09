package controllers.createPlayer;

import controllers.Controller;
import interactors.Interactor;
import interactors.Request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreatePlayerController implements Controller {
    private Interactor interactor;
    private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private BufferedReader view = new BufferedReader(inputStreamReader);

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
