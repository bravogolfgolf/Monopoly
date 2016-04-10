package usecases;

import controllers.View;
import controllers.createBoard.CreateBoardController;
import interactors.Interactor;
import presenters.Presenter;

import java.io.IOException;

public class CreateBoardControllerFake extends CreateBoardController {
    public CreateBoardControllerFake(View view, Interactor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        handle(null);
        String line = "USA";
        handle(line);
    }
}
