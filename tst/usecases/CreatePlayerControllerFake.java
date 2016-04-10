package usecases;

import controllers.Interactor;
import controllers.Presenter;
import controllers.View;
import controllers.createPlayer.CreatePlayerController;

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
