package controllers.createBoard;

import controllers.Controller;
import interactors.Interactor;
import interactors.Request;

import java.io.BufferedReader;
import java.io.IOException;

public class CreateBoardController implements Controller {
    private Interactor interactor;
    private BufferedReader view;

    public void setView(BufferedReader view) {
        this.view = view;
    }

    public void setInteractor(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void sendRequest(Request request) throws IOException {
        interactor.handle(request);

    }
}
