package game.controllers.createPlayer;

import game.controllers.Presenter;
import game.controllers.View;

import java.io.IOException;

class CreatePlayerControllerStub extends CreatePlayerController {
    CreatePlayerControllerStub(View view, CreatePlayerControllerInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.handle(null);
    }
}
