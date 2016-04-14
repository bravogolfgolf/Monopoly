package game.controllers.setupgame;

import game.controllers.Presenter;
import game.controllers.View;

import java.io.IOException;

class SetupGameControllerStub extends SetupGameController {
    SetupGameControllerStub(View view, SetupGameInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("1");
    }
}
