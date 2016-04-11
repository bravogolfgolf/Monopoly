package game.usecases;

import game.controllers.Interactor;
import game.controllers.InteractorPresenter;
import game.controllers.View;
import game.controllers.createBoard.CreateBoardController;

import java.io.IOException;

public class CreateBoardControllerFake extends CreateBoardController {
    public CreateBoardControllerFake(View view, Interactor interactor, InteractorPresenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        handle(null);
        String line = "USA";
        handle(line);
    }
}
