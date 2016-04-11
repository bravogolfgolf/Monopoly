package game.usecases;

import game.controllers.Interactor;
import game.controllers.Presenter;
import game.controllers.View;
import game.controllers.createPlayer.CreatePlayerController;

import java.io.IOException;

public class CreatePlayerControllerFake extends CreatePlayerController {
    public CreatePlayerControllerFake(View view, Interactor interactor, Presenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.handle(null);
        String line = "Cat";
        super.handle(line);
    }
}
