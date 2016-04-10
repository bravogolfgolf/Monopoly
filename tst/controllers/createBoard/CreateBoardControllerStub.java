package controllers.createBoard;

import controllers.View;
import interactors.Interactor;
import presenters.Presenter;

import java.io.IOException;

public class CreateBoardControllerStub extends CreateBoardController {
    public CreateBoardControllerStub(View view, Interactor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.handle(null);
    }
}
