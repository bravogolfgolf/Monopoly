package game.controllers.createPlayer;

import game.controllers.Presenter;
import game.controllers.View;

import java.io.IOException;

class CreatePlayerControllerValidInputStub extends CreatePlayerController {
    CreatePlayerControllerValidInputStub(View view, CreatePlayerInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.parse("1");
    }
}
