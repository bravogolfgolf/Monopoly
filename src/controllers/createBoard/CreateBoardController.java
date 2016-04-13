package game.controllers.createBoard;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.View;
import game.interactors.createboard.CreateBoardRequest;

import java.io.IOException;


public class CreateBoardController implements Controller {
    private final View view;
    private final CreateBoardControllerInteractor interactor;
    private final Presenter presenter;

    public CreateBoardController(View view, CreateBoardControllerInteractor interactor, Presenter presenter) {
        this.view = view;
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        handle(null);
        String line = view.reader.readLine();
        handle(line);
    }

    protected void handle(String text) throws IOException {
        CreateBoardRequest request = new CreateBoardRequest();
        request.version = text;
        interactor.handle(request);
        view.output(presenter.getFormattedMessage());
    }

}
