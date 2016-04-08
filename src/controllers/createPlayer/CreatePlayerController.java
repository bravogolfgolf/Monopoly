package controllers.createPlayer;

import controllers.Controller;
import usecases.Interactor;
import usecases.Request;

import java.io.IOException;

public class CreatePlayerController implements Controller {
    private final Interactor interactor;

    public CreatePlayerController(Interactor interactor) {
        this.interactor = interactor;
    }

    public void sendRequest(Request request) throws IOException {
        interactor.handle(request);
    }
}
