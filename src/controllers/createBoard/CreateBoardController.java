package controllers.createBoard;

import controllers.Controller;
import usecases.Interactor;
import usecases.Request;

import java.io.IOException;

public class CreateBoardController implements Controller {
    private final Interactor interactor;

    public CreateBoardController(Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void sendRequest(Request request) throws IOException {
        interactor.handle(request);

    }
}
