package game.usecases;

import game.controllers.Presenter;
import game.controllers.View;
import game.controllers.createPlayer.CreatePlayerController;
import game.controllers.createPlayer.CreatePlayerInteractor;

import java.io.IOException;

class CreatePlayerControllerStub extends CreatePlayerController {
    CreatePlayerControllerStub(View view, CreatePlayerInteractor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.handle(null);
        String line = "Cat";
        super.handle(line);
    }
}
