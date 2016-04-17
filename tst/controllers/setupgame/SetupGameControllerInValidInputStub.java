package game.controllers.setupgame;

import game.controllers.Presenter;
import game.controllers.View;

import java.io.IOException;

class SetupGameControllerInValidInputStub extends SetupGameController {
    SetupGameControllerInValidInputStub(View view, SetupGameInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("999");
    }
}
