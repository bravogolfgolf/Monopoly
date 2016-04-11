package game.controllers.createBoard;

import game.controllers.Interactor;
import game.controllers.Presenter;
import game.controllers.View;

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
