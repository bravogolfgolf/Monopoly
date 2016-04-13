package game.usecases;

import game.controllers.Presenter;
import game.controllers.View;
import game.controllers.createPlayer.CreatePlayerController;
import game.controllers.createPlayer.CreatePlayerControllerInteractor;

import java.io.IOException;

class CreatePlayerControllerStub extends CreatePlayerController {
    CreatePlayerControllerStub(View view, CreatePlayerControllerInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.handle(null);
        String line = "Cat";
        super.handle(line);
    }
}
