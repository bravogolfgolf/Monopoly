package game.controllers.createPlayer;

import game.Controller;
import game.controllers.Interactor;
import game.controllers.Presenter;
import game.controllers.View;
import game.interactors.createplayer.CreatePlayerRequest;

import java.io.IOException;


public class CreatePlayerController implements Controller {
    private final View view;
    private final Interactor interactor;
    private final Presenter presenter;

    public CreatePlayerController(View view, Interactor interactor, Presenter presenter) {
        this.view = view;
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        handle(null);
        String line = view.reader.readLine();
        handle(line);
    }

    protected void handle(String text) throws IOException {
        CreatePlayerRequest request = new CreatePlayerRequest();
        request.token = text;
        interactor.handle(request);
        view.output(presenter.getFormattedMessage());
    }
}