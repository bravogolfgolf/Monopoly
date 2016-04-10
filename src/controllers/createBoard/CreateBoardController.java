package controllers.createBoard;

import controllers.Interactor;
import controllers.Presenter;
import controllers.View;
import interactors.createboard.CreateBoardRequest;
import main.Controller;

import java.io.IOException;


public class CreateBoardController implements Controller {
    private final View view;
    private final Interactor interactor;
    private final Presenter presenter;

    public CreateBoardController(View view, Interactor interactor, Presenter presenter) {
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
        view.output(presenter.getViewRequest());
    }

}
