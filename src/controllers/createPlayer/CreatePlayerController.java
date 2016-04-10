package controllers.createPlayer;

import controllers.Controller;
import controllers.View;
import interactors.Interactor;
import interactors.createplayer.CreatePlayerRequest;
import presenters.Presenter;

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
    public void handle(String text) throws IOException {
        CreatePlayerRequest request = new CreatePlayerRequest();
        request.token = text;
        interactor.handle(request);
        view.output(presenter.getViewRequest());
    }
}