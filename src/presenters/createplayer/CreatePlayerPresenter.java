package game.presenters.createplayer;

import game.controllers.Presenter;
import game.interactors.Response;
import game.interactors.createplayer.CreatePlayerResponse;

public class CreatePlayerPresenter implements Presenter {
    private String viewRequest;

    @Override
    public void present(Response response) {
        this.viewRequest = ((CreatePlayerResponse) response).message;
    }

    @Override
    public String getViewRequest() {
        return viewRequest;
    }
}
