package game.controllers.createBoard;

import game.controllers.Presenter;
import game.controllers.View;

import java.io.IOException;

class CreateBoardControllerStub extends CreateBoardController {
    CreateBoardControllerStub(View view, CreateBoardInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.handle(null);
    }
}
