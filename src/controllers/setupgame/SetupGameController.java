package game.controllers.setupgame;

import game.Controller;
import game.controllers.Presenter;
import game.controllers.View;
import game.interactors.setupgame.SetupGameRequest;

import java.io.IOException;


public class SetupGameController implements Controller {
    private final View view;
    private final SetupGameInteractor interactor;
    private final Presenter presenter;

    public SetupGameController(View view, SetupGameInteractor interactor, Presenter presenter) {
        this.view = view;
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @Override
    public void execute() throws IOException {
        interactor.boardPromptAndAvailableBoardsMessages();
        updateView();
        String line = view.input();
        handle(line);
    }

    protected void handle(String text) throws IOException {
        SetupGameRequest request = new SetupGameRequest();
        request.version = text;
        interactor.handle(request);
        updateView();
    }

    private void updateView() throws IOException {
        view.output(presenter.getFormattedMessage());
    }

}
