package game.usecases;

import game.controllers.Presenter;
import game.controllers.View;
import game.controllers.setupgame.SetupGameController;
import game.controllers.setupgame.SetupGameInteractor;

import java.io.IOException;

class SetupGameControllerStub extends SetupGameController {
    SetupGameControllerStub(View view, SetupGameInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        handle(null);
        String line = "USA";
        handle(line);
    }
}
