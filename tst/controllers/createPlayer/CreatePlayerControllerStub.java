package game.controllers.createPlayer;

import game.controllers.Interactor;
import game.controllers.InteractorPresenter;
import game.controllers.View;

import java.io.IOException;

public class CreatePlayerControllerStub extends CreatePlayerController {
    public CreatePlayerControllerStub(View view, Interactor interactor, InteractorPresenter presenter) {
        super(view, interactor, presenter);
    }

    @Override
    public void execute() throws IOException {
        super.handle(null);
    }
}
