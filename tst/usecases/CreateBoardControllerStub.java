package game.usecases;

import game.controllers.Presenter;
import game.controllers.View;
import game.controllers.createBoard.CreateBoardController;
import game.controllers.createBoard.CreateBoardInteractor;

import java.io.IOException;

class CreateBoardControllerStub extends CreateBoardController {
    CreateBoardControllerStub(View view, CreateBoardInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        handle(null);
        String line = "USA";
        handle(line);
    }
}
