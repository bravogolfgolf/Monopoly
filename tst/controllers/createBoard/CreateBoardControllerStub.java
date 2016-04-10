package controllers.createBoard;

import controllers.Interactor;
import controllers.Presenter;
import controllers.View;

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
