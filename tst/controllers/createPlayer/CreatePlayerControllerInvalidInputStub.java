package game.controllers.createPlayer;

import game.controllers.Presenter;
import game.controllers.View;

import java.io.IOException;

class CreatePlayerControllerInvalidInputStub extends CreatePlayerController {
    CreatePlayerControllerInvalidInputStub(View view, CreatePlayerInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("999");
    }
}
